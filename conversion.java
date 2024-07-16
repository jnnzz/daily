import javax.swing.*;
import java.awt.event.*;

public class calcFrame extends JFrame implements ActionListener {
    // Your existing code here...

    JButton popupButton;

    public calcFrame() {
        // Initialize other components...

        // Create a new button for popping out the frame
        popupButton = new JButton("Open New Frame");
        popupButton.setBounds(40, 560, 300, 50);
        popupButton.addActionListener(this);

        // Add the popup button to the panel
        panel.add(popupButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == popupButton) {
            // Create a new JFrame object for the popup frame
            JFrame popupFrame = new JFrame("Popup Frame");

            // Set size and visibility for the popup frame
            popupFrame.setSize(300, 200);
            popupFrame.setLocationRelativeTo(null); // Center the frame
            popupFrame.setVisible(true);

            // Add a label to the popup frame
            JLabel label = new JLabel("This is a popup frame");
            label.setHorizontalAlignment(SwingConstants.CENTER);
            popupFrame.add(label);
        }

        // Handle other button actions as before...
    }

    public static void main(String[] args) {
        new calcFrame();
    }
}
