
package com.mycompany.banking_system;

import GUI.Transaction;
import Objects.Account;
import javax.swing.JFrame;


public class Banking_System {

    public static void main(String[] args) {
        Transaction frame  = new Transaction();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        
    }
}
