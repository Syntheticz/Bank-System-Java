
package Objects;

import java.util.Objects;

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
    public void withdraw(double amount) {
        if (accountBalance >= amount) {
            accountBalance -= amount;
            FileHandling fileHandler = new FileHandling();
            fileHandler.saveToFile(this);
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Same instance
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false; // Different classes or null object
        }

        Account otherAccount = (Account) obj;
        // Compare the fields of the two objects for equality
        return Objects.equals(name, otherAccount.name) &&
                Objects.equals(accountNumber, otherAccount.accountNumber) &&
                Objects.equals(dateOfBirth, otherAccount.dateOfBirth) &&
                Objects.equals(pin, otherAccount.pin) &&
                Objects.equals(encryptedAccountBalance, otherAccount.encryptedAccountBalance) &&
                Double.compare(accountBalance, otherAccount.accountBalance) == 0;
    }
    
    
    public void deposit(double amount) {
        accountBalance += amount;
        System.out.println(this.accountNumber);

        FileHandling fileHandler = new FileHandling();
        fileHandler.saveToFile(this);
        System.out.println("Deposit successful.");
        System.out.println(accountNumber + " : " + this.accountNumber);
        fileHandler.saveReciept(this.accountNumber);
    }
    
  
    
    public void transfer(Account destinationAccount, double amount) {
        if (accountBalance >= amount) {
            accountBalance -= amount;
            
            FileHandling fileHandler = new FileHandling();
            fileHandler.saveToFile(this);
            destinationAccount.accountBalance += amount;
            fileHandler.saveToFile(destinationAccount);
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Insufficient funds for transfer.");
        }
    }
}