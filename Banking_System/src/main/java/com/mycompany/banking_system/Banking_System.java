
package com.mycompany.banking_system;

import GUI.Receipt;
import Objects.Account;
import javax.swing.JFrame;
import GUI.Main_Menu;

import Objects.FileHandling;

public class Banking_System {

    public static void main(String[] args) {   
           Account acc = new Account();
           acc.setName("Philips");
           acc.setAccountBalance(269.689);
           acc.setAccountNumber("123452");
           acc.setEncryptedAccountBalance("1");
           acc.setDateOfBirth("12-07-2001");
           acc.setPin("1234");
           
   
           
           FileHandling file = new FileHandling();
           file.saveToFile(acc);
           
           Account acc1 = file.fetchAccount("123452");
           System.out.println("Name: " + acc1.getAccountBalance());
    }
}
