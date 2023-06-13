
package UI_Components;

import javax.swing.JFrame;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Manuel Marin
 */
public class PinField extends PasswordField
{
    private final int maxLength = 4;
    
    public PinField(JFrame frame, String placeholder, int col) {
        super(frame, placeholder, col);
        
        PlainDocument doc = (PlainDocument) getDocument();
        doc.setDocumentFilter(new IntegerFilter());
    }
    
    protected class IntegerFilter extends Filter 
    {
        @Override
        protected boolean test(String text) {
            try {
                if (text.length() >= maxLength) {
                    setValid();
                } else setInvalid();
                
                return text.length() <= maxLength && text.matches("\\d*");
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }
    
}
