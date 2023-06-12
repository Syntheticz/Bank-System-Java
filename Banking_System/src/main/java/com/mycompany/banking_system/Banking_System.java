
package com.mycompany.banking_system;

import GUI.Receipt;
import Objects.Account;
import javax.swing.JFrame;
import GUI.Main_Menu;
import GUI.Transaction;

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
           
           Account act = new Account();
           act.setName("Lex");
           act.setAccountBalance(70000.69);
           act.setAccountNumber("654321");
           act.setEncryptedAccountBalance("10101010");
           act.setDateOfBirth("03-07-2005");
           act.setPin("1234");
           
//           Main_Menu main = new Main_Menu();

            FileHandling filehandler = new FileHandling();
            Account ac1 = filehandler.fetchAccount(acc.getAccountNumber());

            Transaction transaction = new Transaction(ac1);
            transaction.setVisible(true);
            transaction.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
           //acc.deposit(50000);
           
           //FileHandling fileHandler = new FileHandling();
           //Account ac1 = fileHandler.fetchAccount("123452");
           
           //System.out.println("Dec: " + ac1.getAccountBalance());
           //acc.withdraw(60000);
           //acc.transfer(act, 10000);
           //System.out.println("user bal:"+ acc.getAccountBalance());
           //System.out.println("receiver bal:"+ act.getAccountBalance());
           
           

    }
}
