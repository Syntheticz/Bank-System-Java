
package Objects;

public class Account {
    private String name;
    private String accountNumber;
    private String dateOfBirth;
    private String pin;
    private String encryptedAccountBalance;
    private double accountBalance;

    // Constructors
    public Account() {
        // Default constructor
    }

    public Account(String name, String accountNumber, String dateOfBirth, String pin, String encryptedAccountBalance, double accountBalance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.dateOfBirth = dateOfBirth;
        this.pin = pin;
        this.encryptedAccountBalance = encryptedAccountBalance;
        this.accountBalance = accountBalance;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getEncryptedAccountBalance() {
        return encryptedAccountBalance;
    }

    public void setEncryptedAccountBalance(String encryptedAccountBalance) {
        this.encryptedAccountBalance = encryptedAccountBalance;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
    
    //Methods
    
    
}
