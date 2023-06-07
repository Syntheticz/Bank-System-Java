
package com.mycompany.banking_system;

import GUI.Withdraw;
import Objects.Account;
import javax.swing.JFrame;


public class Banking_System {

    public static void main(String[] args) {
        Withdraw frame  = new Withdraw();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        
    }
}
