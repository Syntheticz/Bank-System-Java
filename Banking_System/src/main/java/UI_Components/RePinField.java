
package UI_Components;


import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Manuel Marin
 */
public class RePinField extends PasswordField
{
    private final int maxLength = 4;
    private final JTextField pinField;
    
    public RePinField(JFrame frame,JTextField pinField, String placeholder, int col) {
        super(frame, placeholder, col);
        
        PlainDocument doc = (PlainDocument) getDocument();
        doc.setDocumentFilter(new IntegerFilter());
        
        this.pinField = pinField;
    }
    
    protected class IntegerFilter extends Filter
    {
        @Override
        protected boolean test(String text) {
            try {
                int value = Integer.parseInt(text);
                int reValue = Integer.parseInt(pinField.getText());
                if (value == reValue) {
                    setValid();
                } else setInvalid();
                return text.length() <= maxLength && text.matches("\\d*");
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }
} 
