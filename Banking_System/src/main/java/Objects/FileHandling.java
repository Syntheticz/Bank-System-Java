/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author philip
 */
public class FileHandling{
   
    final String clientSideRecordsFileName = "records.dat";
    final String adminSideRecordsFileName = "records.txt";
    final String logFileName = "log.txt";
    
     public void save(Account account) {
        String desktopPath = System.getProperty("user.home") + File.separator + "Desktop";

        try (RandomAccessFile file = new RandomAccessFile(desktopPath + clientSideRecordsFileName, "rw")) {
            //encryptAccount(account);
            

            // Search for the account by account number
            long fileSize = file.length();
            long currentPosition = 0;

            while (currentPosition < fileSize) {
                Account temp = readAccountFromFile(file);
                if (temp.getAccountNumber().equals(account.getAccountNumber())) {
                    // Found the account, overwrite it with the new data
                    file.seek(currentPosition);
                    writeAccountToFile(file, account);
                    return;
                }
                currentPosition = file.getFilePointer();
            }

            // Account not found, append it to the end of the file
            file.seek(fileSize);
            writeAccountToFile(file, account);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void encryptAccount(Account account) {
        // Perform encryption logic here
        // ...
    }

    private Account readAccountFromFile(RandomAccessFile file) throws IOException {
        String name = file.readUTF();
        String accountNumber = file.readUTF();
        String dateOfBirth = file.readUTF();
        String pin = file.readUTF();
        String encryptedAccountBalance = file.readUTF();
        double accountBalance = file.readDouble();
        return new Account(name, accountNumber, dateOfBirth, pin, encryptedAccountBalance, accountBalance);
    }

    private void writeAccountToFile(RandomAccessFile file, Account account) throws IOException {
        file.writeUTF(account.getName());
        file.writeUTF(account.getAccountNumber());
        file.writeUTF(account.getDateOfBirth());
        file.writeUTF(account.getPin());
        file.writeUTF(account.getEncryptedAccountBalance());
        file.writeDouble(account.getAccountBalance());
    }
   
   
   



}
