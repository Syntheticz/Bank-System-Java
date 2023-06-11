
package com.mycompany.banking_system;

import GUI.Receipt;
import Objects.Account;
import javax.swing.JFrame;
import GUI.Main_Menu;

import Objects.FileHandling;

public class Banking_System {

    public static void main(String[] args) {   
           Account acc = new Account();
           acc.setName("Philip");
           acc.setAccountBalance(69421.69);
           acc.setAccountNumber("123456");
           acc.setEncryptedAccountBalance("66969696");
           acc.setDateOfBirth("12-07-2001");
           acc.setPin("1234");
           
           Account act = new Account();
           act.setName("Lex");
           act.setAccountBalance(70000.69);
           act.setAccountNumber("654321");
           act.setEncryptedAccountBalance("10101010");
           act.setDateOfBirth("03-07-2005");
           act.setPin("1234");
           
           
           //acc.deposit(50000);
           //acc.withdraw(60000);
           //acc.transfer(act, 10000);
           //System.out.println("user bal:"+ acc.getAccountBalance());
           //System.out.println("receiver bal:"+ act.getAccountBalance());
           
           
    }
}
