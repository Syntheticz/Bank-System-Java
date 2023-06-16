/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI_Components;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author philip
 */
public class PinValidator {
      
    //default Constructor
    public PinValidator(){
        
    }
    
    public void validatePin(JPasswordField passwordField){
     ((AbstractDocument) passwordField.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (isDigit(string) && fb.getDocument().getLength() < 4) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (isDigit(text) && fb.getDocument().getLength() - length + text.length() <= 4) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            private boolean isDigit(String text) {
                return text.matches("\\d");
            }
        });
        
        // Set the input verifier to validate the input
        passwordField.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                String password = new String(passwordField.getPassword());
                
                // Verify if the password has exactly 4 digits
                if (password.matches("\\d{4}")) {
                    return true;
                } else {
                    return false;
                }
            }
        });
    }
}
