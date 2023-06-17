/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI_Components;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

/**
 *
 * @author philip
 */
public class amountValidate {
    
    public amountValidate(){
        
    }
    
    public void validate(JTextField textField){
        PlainDocument document = new PlainDocument();
        document.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                StringBuilder builder = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
                builder.insert(offset, string);

                if (isNumeric(builder.toString())) {
                    fb.insertString(offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                StringBuilder builder = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
                builder.replace(offset, offset + length, text);

                if (isNumeric(builder.toString())) {
                    fb.replace(offset, length, text, attrs);
                }
            }

            private boolean isNumeric(String text) {
                return text.matches("\\d+(\\.\\d{0,2})?");
            }
        });
        
        textField.setDocument(document);
    }
}
