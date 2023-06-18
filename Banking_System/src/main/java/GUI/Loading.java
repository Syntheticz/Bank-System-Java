
package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 *
 * @author Manuel Marin
 */

public class Loading {
    private static int angle = 0; // Declare angle as a field
    public Loading() {
        showLoadingPopup("Please wait, We're processing your transaction", 3000);
    }

   public static void showLoadingPopup(String message, int duration) {
        JDialog dialog = new JDialog((Frame) null, true);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setUndecorated(true);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel loadingPanel = new JPanel() {
            private final int radius = 20;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.BLUE);
                int size = radius * 2;
                int x = (getWidth() - size) / 2;
                int y = (getHeight() - size) / 2;
                g2.rotate(Math.toRadians(angle), getWidth() / 2, getHeight() / 2);
                g2.fillArc(x, y, size, size, 0, 90);
                g2.dispose();
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(2 * radius, 2 * radius);
            }
        };
        panel.add(loadingPanel, BorderLayout.CENTER);

        JLabel label = new JLabel(message);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label, BorderLayout.PAGE_END);

        dialog.getContentPane().add(panel);
        dialog.pack();
        dialog.setLocationRelativeTo(null);

        Timer timer = new Timer(35, new ActionListener() {
            private final int rotationSpeed = 20;

            @Override
            public void actionPerformed(ActionEvent e) {
                angle = (angle + rotationSpeed) % 360; // Update the angle field
                loadingPanel.repaint();
            }
        });
        timer.start();

        Timer closeTimer = new Timer(duration, (ActionEvent e) -> {
            dialog.dispose();
        });
        closeTimer.setRepeats(false);
        closeTimer.start();
        
        
        dialog.setAlwaysOnTop(true); // Set the dialog always on top
        dialog.setFocusableWindowState(true); // Set the dialog to be focused
        dialog.setVisible(true);
    }
}