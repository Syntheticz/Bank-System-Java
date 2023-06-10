package Objects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;






public class FileHandling {

    final private String recordsFileName = "records.text";
    
    public void saveToFile(Account account){
        Encryption enc = new Encryption();

        enc.encryptAccount(account);
        
        save("atm", account);
        save("admin", account);
    }
    
    private String getFilePath(String folderName, String fileName){
         String projectDirectory = System.getProperty("user.dir");

        String folderPath = projectDirectory + File.separator + folderName;
        return folderPath + File.separator + recordsFileName;
        
    }
    
    private Account fetchAccountFromFile(String accountNumber, String folderName){
        return readAccountByAccountNumber(getFilePath(folderName, recordsFileName), accountNumber);
    }
    
    public Account fetchAccount(String accounNumber){
        
        Account accountFromATM = fetchAccountFromFile(accounNumber, "atm");   
        Account accountFromAdmin = fetchAccountFromFile(accounNumber, "admin");
        
        if(accountFromAdmin.equals(accountFromATM)){
            Account acc = readAccountByAccountNumber(getFilePath("atm", recordsFileName), accounNumber);

            return acc;
        }else{
            return null;
        }
    }
    
    private void save(String folderName, Account account) {
     String projectDirectory = System.getProperty("user.dir");
     String folderPath = projectDirectory + File.separator + folderName;
     String filePath = folderPath + File.separator + recordsFileName;

     try {
         File folder = new File(folderPath);
         if (!folder.exists()) {
             folder.mkdirs();
             System.out.println("Created folder: " + folderPath);
         }

         File file = new File(filePath);
         if (!file.exists()) {
             file.createNewFile();
         }

         // Read existing records
         List<Account> existingAccounts = readAccounts(filePath);
         
         //Encryption
         
         // Check if account number already exists
         boolean accountExists = false;
         for (int i = 0; i < existingAccounts.size(); i++) {
             Account existingAccount = existingAccounts.get(i);
             if (existingAccount.getAccountNumber().equals(account.getAccountNumber())) {
                 accountExists = true;
                 existingAccounts.set(i, account); // Update the existing account
                 break;
             }
         }

         FileWriter writer = new FileWriter(filePath, false); // Overwrite the entire file

         if (accountExists) {
             System.out.println("Account already exists. Updating record...");
         } else {
             System.out.println("Account not found. Appending record...");
             existingAccounts.add(account); // Append the new account
         }

         // Write all the accounts back to the file
         for (Account existingAccount : existingAccounts) {
             writeAccount(writer, existingAccount);
         }

         writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static List<Account> readAccounts(String filePath) {
        List<Account> accounts = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 6) {
                    String name = fields[0];
                    String accountNumber = fields[1];
                    String dateOfBirth = fields[2];
                    String pin = fields[3];
                    String encryptedAccountBalance = fields[4];
                    double accountBalance = Double.parseDouble(fields[5]);
                    Account account = new Account(name, accountNumber, dateOfBirth, pin,
                            encryptedAccountBalance, accountBalance);
                    accounts.add(account);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return accounts;
    }
    
    private static Account readAccountByAccountNumber(String filePath, String accountNumber) {
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(",");
            if (fields.length == 6) {
                String name = fields[0];
                String currentAccountNumber = fields[1];
                String dateOfBirth = fields[2];
                String pin = fields[3];
                String encryptedAccountBalance = fields[4];
                double accountBalance = Double.parseDouble(fields[5]);
                
                Account temp = new Account(name, currentAccountNumber, dateOfBirth, pin,
                            encryptedAccountBalance, accountBalance);
                Encryption dec = new Encryption();
                dec.decryptAccount(temp);

                if (temp.getAccountNumber().equals(accountNumber)) {
                    return temp;
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return null; // Account not found
}

     private static void writeAccount(FileWriter writer, Account account) throws IOException {
        writer.append(account.getName()).append(",");
        writer.append(account.getAccountNumber()).append(",");
        writer.append(account.getDateOfBirth()).append(",");
        writer.append(account.getPin()).append(",");
        writer.append(account.getEncryptedAccountBalance()).append(",");
        writer.append(Double.toString(account.getAccountBalance()));
        writer.append("\n");
    }

}