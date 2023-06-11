
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
           
<<<<<<< HEAD
   
   
=======
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
           
           
>>>>>>> 0d0e7e6e752b9c6383253a3a21be0c4f4c3d089f
    }
}
