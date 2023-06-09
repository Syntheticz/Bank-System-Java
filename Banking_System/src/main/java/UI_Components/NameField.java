
package UI_Components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Manuel Marin
 */
public class NameField extends TextField
{
    private final int maxLength = 20;
    public NameField(JFrame frame, String placeholder, int col) {
        super(frame, placeholder, col);
        
        PlainDocument doc = (PlainDocument) getDocument();
        doc.setDocumentFilter(new StringFilter());
    }
    
    protected class StringFilter extends Filter
    {
        @Override
        protected boolean test(String text) {
            if (text.length() >= 5) {
                setValid(); 
            } else setInvalid();
            System.out.print("yo");
            return text.matches("[a-zA-Z]*");
        }
    }
    
        
   
    
}
