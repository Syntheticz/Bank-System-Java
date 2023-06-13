package Objects;

import java.text.DecimalFormat;


public class Encryption {

    private static final int KEY = 5; // Key for encryption/decryption

    public void encryptAccount(Account account) {
        account.setName(swapChars(account.getName(), KEY));
        account.setAccountNumber(swapChars(account.getAccountNumber(), KEY));
        account.setDateOfBirth(swapChars(account.getDateOfBirth(), KEY));
        account.setPin(swapChars(account.getPin(), KEY));
        account.setEncryptedAccountBalance(encryptDecimal(account.getAccountBalance()));
        account.setAccountBalance(0);

    }

    public void decryptAccount(Account account) {
        account.setName(restoreChars(account.getName(), KEY));
        account.setAccountNumber(restoreChars(account.getAccountNumber(), KEY));
        account.setPin(restoreChars(account.getPin(), KEY));
        account.setDateOfBirth(restoreChars(account.getDateOfBirth(), KEY));
        account.setAccountBalance(decryptDecimal(account.getEncryptedAccountBalance()));
    }

    private static String swapChars(String str, int key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int asciiCode = (int) str.charAt(i);
            asciiCode += key;
            result.append((char) asciiCode);
        }
        return result.toString();
    }

    private static String restoreChars(String str, int key) {
        return swapChars(str, -key);
    }

    private static String encryptDecimal(double amount) {
        
        amount = Math.floor((amount * 100) * 100)/ 100;
        int finalAmount = (int) amount;
        String str = String.valueOf(amount);
        
        return swapChars(str, KEY);
    }

    private static double decryptDecimal(String str) {
        str = restoreChars(str, KEY);
        DecimalFormat format = new DecimalFormat("#.##");
        double amount = Double.parseDouble(format.format(Double.parseDouble(str) / 100));
        return amount;
    }
}
