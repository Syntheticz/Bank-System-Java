
package Objects;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class TransactionLog {
    private final String accountNumber;
    private final String transactionType;
    private double transactionAmount;
    private final String transactionTimestamp;

    public TransactionLog(String accountNumber, String transactionType, double transactionAmount) {
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.transactionTimestamp = getDateTime();
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
        return "[" + transactionTimestamp + "] " + transactionType + " | Account Number: " + accountNumber +
            " | Amount: P" + transactionAmount;
    }
    
    
}
