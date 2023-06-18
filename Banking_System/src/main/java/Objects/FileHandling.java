package Objects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;






public class FileHandling {

    final private String recordsFileName = "records.text";
    final private String logsFileName = "log.text";

    
    public void saveToFile(Account account){
        Encryption enc = new Encryption();
        
        
        Account temp = new Account(account.getName(), account.getAccountNumber(), account.getDateOfBirth(),
        account.getPin(), account.getEncryptedAccountBalance(), account.getAccountBalance());

        enc.encryptAccount(temp);
        
        save("atm", temp);
        save("admin", temp);
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
        
        if(accountFromAdmin == null || accountFromATM == null){
            return null;
        }
        
        if(accountFromAdmin.equals(accountFromATM)){
            Account acc = readAccountByAccountNumber(getFilePath("atm", recordsFileName), accounNumber);

            return acc;
        }else{
            return null;
        }
    }
    
    private static String extractMonth(String dateTimeString) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yyyy 'at' hh:mm a");
            Date dateTime = sdf.parse(dateTimeString);
            SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM");
            return monthFormat.format(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private static List<TransactionLog> readReport(){
        String projectDirectory = System.getProperty("user.dir");
        String folderPath = projectDirectory + File.separator + "admin";
        String filePath = folderPath + File.separator + "Report.txt";
        
        
         List<TransactionLog> reports = new ArrayList<>();
        
         try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            
            File folder = new File(folderPath);
            if (!folder.exists()) {
                System.out.println("Folder Does not Exist ");
            }

            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("File does not exist");
            }
            
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 4) {
                    String date = fields[0];
                    String type = fields[1];
                    double amount = Double.parseDouble(fields[2]);
                    String accountNumber = fields[3];
                    TransactionLog report = new TransactionLog(accountNumber, type, amount, date);
                    reports.add(report);
                    
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
         
        return reports;
    }
    
    private List<Account> decryptedClientList(){
        String projectDirectory = System.getProperty("user.dir");
        String folderPath = projectDirectory + File.separator + "admin";
        String filePath = folderPath + File.separator + recordsFileName;
        Encryption encryptor = new Encryption();
        
        List<Account> accs = readAccounts(filePath);
        List<Account> accounts = new ArrayList<>();
        for(Account acc : accs){
            encryptor.decryptAccount(acc);
            accounts.add(acc);
        }
        return accounts;
    }
    
    public void generateMonthlyReportForClients(){
        String projectDirectory = System.getProperty("user.dir");
        String folderPath = projectDirectory + File.separator + "reports";

        
        List<TransactionLog> reports = readReport(); 
        List<Account> accounts = decryptedClientList();
        
        if(!reports.isEmpty() || !accounts.isEmpty()){
            //generate folders
            try{
                
                File folder = new File(folderPath);
                if (!folder.exists()) {
                    folder.mkdirs();
                    System.out.println("Created folder: " + folderPath);
                }
                
               
               
               List<String> months = new ArrayList<>();
               //GetMonths
               for(TransactionLog report : reports){
                        if(months.isEmpty()){
                            months.add(extractMonth(report.getTransactionTimestamp()));
                        }else{
                            for(String month : months){
                                if(!month.equals(extractMonth(report.getTransactionTimestamp()))){
                                    months.add(extractMonth(report.getTransactionTimestamp()));
                                }
                            }
                        }
                   }
               
               
               for(String month : months){
                   System.out.println(month);
               }
               
               List<List<TransactionLog>> total = new ArrayList<>();
               
               //get Total
               for(Account account : accounts){
                   
                   for(String month : months){
                       double Withdrawal = 0, Deposit = 0, Transfer = 0;

                       for(TransactionLog report : reports){
                       if(account.getAccountNumber().equals(report.getAccountNumber()) && extractMonth(report.getTransactionTimestamp()).equals(month)){
                           if(report.getTransactionType().equals("Withdrawal")){
                               Withdrawal = Withdrawal + report.getTransactionAmount();
                           }else if(report.getTransactionType().equals("Deposit")){
                               Deposit = Deposit + report.getTransactionAmount();
                           }else if(report.getTransactionType().equals("Transfer")){
                               Transfer = Transfer + report.getTransactionAmount();
                           }
                       }


                       TransactionLog w = new TransactionLog( account.getAccountNumber(), "Withdrawal",  Withdrawal, month);
                       TransactionLog d = new TransactionLog( account.getAccountNumber(), "Deposit",  Deposit, month);
                       TransactionLog t = new TransactionLog( account.getAccountNumber(), "Transfer",  Transfer, month);
                       List<TransactionLog> temp = new ArrayList<>();
                       temp.add(w);
                       temp.add(d);
                       temp.add(t);
                       total.add(temp);
                   }

                   }
                   
               }
                
               for(String month : months){
                    String filePath = folderPath + File.separator + month;

                    File monthFolder = new File(filePath);
                    if (!monthFolder.exists()) {
                        monthFolder.mkdirs();
                        System.out.println("Created folder: " + filePath);
                    }  
                    
                    if(total.isEmpty()){
                        System.out.println("Empty");
                    }
                    
                    for(List<TransactionLog> list : total){
                        
                        File file = new File(filePath + File.separator + list.get(0).getAccountNumber() + ".txt");
                            if (!file.exists()) {
                                file.createNewFile();
                                System.out.println("Created file: " + filePath);
                        }
                            
                        FileWriter writer = new FileWriter(file);
                        writer.append("|\t\tMonthly Report\t\t\t|").append("\n")
                              .append("|\t\tMonth of : " + month + " \t\t|\n")
                              .append("|\tAccount Number : " + list.get(0).getAccountNumber() + " \t\t|\n")
                              .append("\tTotal Witdrawn Amount : " + String.valueOf(list.get(0).getTransactionAmount()) + " \n") 
                              .append("\tTotal Deposited Amount : " + String.valueOf(list.get(1).getTransactionAmount()) + " \n")
                              .append("\tTotal Transfered Amount : " + String.valueOf(list.get(2).getTransactionAmount()) + " \n") 
;                       writer.close();
                       
                    }
                    
                    
               }
               
              
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }else{
            System.out.println("There are no reports to Generate!");
            return;
        }
        
    }
    
    
    public void saveLogForReport(String accountNumber, double transactionAmount, String transactonType, String transactionTime ){
        String projectDirectory = System.getProperty("user.dir");
        String folderPath = projectDirectory + File.separator + "admin";
        String filePath = folderPath + File.separator + "Report.txt";
        
        TransactionLog report = new TransactionLog(accountNumber, transactonType, transactionAmount);
        String log = transactionTime + "," + transactonType + "," + transactionAmount + "," + accountNumber;
        
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

        try (FileWriter writer = new FileWriter(filePath, true)) {  // Pass true to append text
            writer.append(log).append("\n");
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
    }
    
    
   public void saveLog(String log) {
    final String folderName = "Logs";
    String projectDirectory = System.getProperty("user.dir");
    String folderPath = projectDirectory + File.separator + folderName;
    String filePath = folderPath + File.separator + logsFileName;

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

        try (FileWriter writer = new FileWriter(filePath, true)) {  // Pass true to append text
            writer.append(log).append("\n");
        }
    } catch (IOException e) {
        e.printStackTrace();
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
     
     
    private String getDateTime() {

        LocalDateTime now = LocalDateTime.now();
        
        // Define the desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M-d-yyyy_h-mm-a");
        
        // Format the LocalDateTime object
        String formattedDateTime = now.format(formatter);
        
        return formattedDateTime;
    }
     
    public void saveReceipt(String accountNumber, String transactionType, double transactionAmount){
        Account account = fetchAccount(accountNumber);
        
        TransactionLog log = new TransactionLog(accountNumber, transactionType, transactionAmount);
        
        String fileName = getDateTime()+ "_" + account.getAccountNumber()+ ".txt";
        
        
        final String folderName = "Receipts";
        
        String projectDirectory = System.getProperty("user.dir");
        String folderPath = projectDirectory + File.separator + folderName;
        String filePath = folderPath + File.separator + fileName;
     
        try{
            File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdirs();
                System.out.println("Created folder: " + folderPath);
            }

            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }

            try (FileWriter writer = new FileWriter(filePath)) {
                writer.append(log.getLog()).append("\n");
                writer.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        
       
    }

}
