
package Objects;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class TransactionLog {
    private String accountNumber;
    private String transactionType;
    private double transactionAmount;
    private String transactionTimestamp;
    
    //Default Constrctor
    public TransactionLog(){
        
    }

    public TransactionLog(String accountNumber, String transactionType, double transactionAmount) {
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.transactionTimestamp = getDateTime();
    }
    
    public TransactionLog(String accountNumber, String transactionType, double transactionAmount, String timeStamp) {
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.transactionTimestamp = timeStamp;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionTimestamp() {
        return transactionTimestamp;
    }

    public void setTransactionTimestamp(String transactionTimestamp) {
        this.transactionTimestamp = transactionTimestamp;
    }


    public String getDateTime() {

        LocalDateTime now = LocalDateTime.now();
        
        // Define the desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy 'at' h:mm a");
        
        // Format the LocalDateTime object
        String formattedDateTime = now.format(formatter);
        
        return formattedDateTime;
    }
    
    public String getLog() {
        return "[" + this.transactionTimestamp + "] " + "Transaction Type: " + this.transactionType + " | Account Number: " + this.accountNumber +
            " | Amount: P" + this.transactionAmount;
    }
   
    
    public void saveLog(){
        FileHandling file = new FileHandling();
        file.saveLog(getLog());
        file.saveLogForReport(accountNumber, transactionAmount, transactionType, transactionTimestamp);
    }
}
