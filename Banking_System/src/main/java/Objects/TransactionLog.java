
package Objects;


public class TransactionLog {
    private String accountNumber;
    private String transactionType;
    private double transactionAmount;
    private String transactionTimestamp;

    public TransactionLog(String accountNumber, String transactionType, double transactionAmount, String transactionTimestamp) {
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.transactionTimestamp = transactionTimestamp;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public String getTransactionTimestamp() {
        return transactionTimestamp;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public void setTransactionTimestamp(String transactionTimestamp) {
        this.transactionTimestamp = transactionTimestamp;
    }
}
