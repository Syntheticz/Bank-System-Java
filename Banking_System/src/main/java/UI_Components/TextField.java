
package UI_Components;

/**
 *
 * @author Manuel Marin
 */


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

public class TextField extends JTextField {
    
    private final String placeholder;
    private final int column;
    private int maxLength;
  
    
    public TextField(JFrame frame, String placeholder, int col) {
        this.placeholder = placeholder;
        this.column = col;
        setColumns(column);
        setPreferredSize(new Dimension(616, 59));
        
        PlainDocument doc = (PlainDocument) getDocument();
        doc.setDocumentFilter(new Filter());
    }
    
   
    public void setValid() { this.setBorder(new LineBorder(Color.GREEN)); } 
    public void setInvalid() { this.setBorder(new LineBorder(Color.RED)); } 
    
    public boolean isValid() { 
        
        Border border = getBorder();
        if (border instanceof LineBorder lineBorder) {
            if (lineBorder.getLineColor().equals(Color.RED)) {
                return false;
            }
        }
        return true;
    }
    
    public void setMaxLength(int l) { maxLength = l; }
    
    public JTextField getField() { return this; }
   
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // If the text field is empty, show the placeholder text
        if (getText().isEmpty()) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(Color.GRAY);
            g2.setFont(getFont().deriveFont(Font.PLAIN));
            g2.drawString(placeholder, getInsets().left + 3, (getHeight() + g2.getFontMetrics().getAscent()) / 2);
            g2.dispose();
        }
    }
    
    protected class Filter extends DocumentFilter {
        @Override
        public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr)
                throws BadLocationException {
            StringBuilder sb = new StringBuilder();
            sb.append(fb.getDocument().getText(0, fb.getDocument().getLength()));
            sb.insert(offset, string);
           
            if (test(sb.toString())) {
               
                super.insertString(fb, offset, string, attr);
            }
           
        }

        @Override
        public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                throws BadLocationException {
            StringBuilder sb = new StringBuilder();
            sb.append(fb.getDocument().getText(0, fb.getDocument().getLength()));
            sb.replace(offset, offset + length, text);
             
            if (test(sb.toString())) {
               
                super.replace(fb, offset, length, text, attrs);
            }
        }
        
        @Override
        public void remove(DocumentFilter.FilterBypass fb, int offset, int length) throws BadLocationException {
            StringBuilder sb = new StringBuilder();
            sb.append(fb.getDocument().getText(0, fb.getDocument().getLength()));
            sb.delete(offset, offset + length);

            if (test(sb.toString())) {
                super.remove(fb, offset, length);
            }
        }

        protected boolean test(String text) {
            return true;
        }
    }
}
