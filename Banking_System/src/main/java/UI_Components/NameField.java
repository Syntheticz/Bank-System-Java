
package UI_Components;


import javax.swing.JFrame;
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
        
        protected boolean test(String text) {
            if (text.length() >= 5) {
                setValid(); 
            } else {
                setInvalid();
            }
            if (text.length() > maxLength){
                return false;
            }
            return text.matches("[a-zA-Z\\s]*");
        }
    
    }
}
