package GUI;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JProgressBar;
import javax.swing.JFrame;
import javax.swing.JPanel;
import UI_Components.RoundLabel;
import javax.swing.JLabel;
//import GUI.Register;
import java.awt.Dimension;
import java.net.URL;
import javax.swing.ImageIcon;


/**
 *
 * @author simon
 */
public final class TransactionLoading {
    //Containers
    JFrame frame = new JFrame();
    JPanel panel_container = new JPanel();
    
    // Color
    Color title_backgroundColor = new Color(231, 230, 221);
    Color title_foregroundColor = new Color(0,0,0);
    
    //Progress Bar
    JProgressBar loading = new JProgressBar(0, 2000);
    int i=0;
    
    //Title Label
    RoundLabel title_field = new RoundLabel("Processing Transaction...", title_backgroundColor, title_foregroundColor);
    
    //Layout
    GridBagLayout layout = new GridBagLayout();
    
    //Layout Constraint
    GridBagConstraints gbc = new GridBagConstraints();
    
    //Logo
    JLabel logo = new JLabel();
    

    
    public TransactionLoading(JFrame rootFrame)
    {
        setup_comp();
        setup_frame(rootFrame);
    }
    
    private void switchToNext()
    {
        //palitan nalang ng kung anong frame
        frame.dispose();
        Register next = new Register(frame);
        next.setup_frame(frame);
    }
    
    public void iterate()
    {    
        Thread iterationThread = new Thread(() -> {
            while(i<=2000)
            {
                loading.setValue(i);
                i += 20;
                try
                {
                    Thread.sleep(55);
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            
            if(loading.getValue() >= 100)
            {
                switchToNext();
            }
           
        });
        iterationThread.start();
        
    }
    

    
    public void setup_comp()
    {
        panel_container.setLayout(layout);
        panel_container.setBackground(new Color(231, 230, 221));
        
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(0, 0, 40, 0);
        
        loading.setPreferredSize(new Dimension(300, 30));  
        loading.setValue(0);
        loading.setStringPainted(true);
        loading.setForeground(new Color(51,97,172));
        
        URL imgUrl = getClass().getResource("/Logo/new.png");
        logo.setIcon(new ImageIcon(imgUrl));
        logo.setPreferredSize(new Dimension(200, 125));
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel_container.add(loading, gbc);
        iterate();
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel_container.add(title_field, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel_container.add(logo, gbc);
        
    }
    
    public void setup_frame(JFrame rootFrame)
    {
        frame.add(panel_container);
        
        frame.setSize(rootFrame.getSize());
        frame.setLocation(rootFrame.getLocation());
       
        frame.setVisible(true); 
    }
}
