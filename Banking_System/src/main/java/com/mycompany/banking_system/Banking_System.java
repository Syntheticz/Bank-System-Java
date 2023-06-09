
package com.mycompany.banking_system;

import GUI.Receipt;
import Objects.Account;
import javax.swing.JFrame;


public class Banking_System {

    public static void main(String[] args) {
        Receipt frame  = new Receipt();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        
    }
}
