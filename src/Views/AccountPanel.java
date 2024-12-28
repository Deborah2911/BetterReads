package Views;

import Database.DBConnection;
import Database.User;

import javax.swing.*;
import java.awt.*;

public class AccountPanel extends JPanel {
    public AccountPanel(User account) {
        // Set layout and background for the account panel
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.WHITE);

        // Create labels and components
        JLabel fullNameLabel = new JLabel("Full name: " + account.getName());
        JLabel usernameLabel = new JLabel("Username: " + account.getUsername());
        JLabel passwordLabel = new JLabel("Password: ");

        JPasswordField passwordField = new JPasswordField(account.getPassword());
        passwordField.setEchoChar('•'); // Hide characters with a bullet
        passwordField.setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
        passwordField.setForeground(new Color(75, 37, 100));
        passwordField.setEditable(false); // Make it non-editable

        JButton togglePasswordButton = new JButton("Show");
        togglePasswordButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        togglePasswordButton.addActionListener(e -> {
            if (passwordField.getEchoChar() == '•') {
                passwordField.setEchoChar((char) 0); // Show password
                togglePasswordButton.setText("Hide");
            } else {
                passwordField.setEchoChar('•'); // Hide password
                togglePasswordButton.setText("Show");
            }
        });

        JButton modifyUsernameButton = new JButton("Modify Username");
        modifyUsernameButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        modifyUsernameButton.addActionListener(e -> {
            JTextField usernameField = new JTextField(account.getUsername(), 20);
            int result = JOptionPane.showConfirmDialog(null, usernameField,
                    "Modify Username", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                if (DBConnection.modifyUsername(account.getUsername(), usernameField.getText())) {
                    account.setUsername(usernameField.getText());
                    usernameLabel.setText("Username: " + account.getUsername());
                } else {
                    JOptionPane.showMessageDialog(null, "Error while modifying username. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton modifyFullNameButton = new JButton("Modify Full Name");
        modifyFullNameButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        modifyFullNameButton.addActionListener(e -> {
            JTextField fullNameField = new JTextField(account.getName(), 20);
            int result = JOptionPane.showConfirmDialog(null, fullNameField,
                    "Modify Full Name", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                if (DBConnection.modifyName(account.getName(), fullNameField.getText())) {
                    account.setName(fullNameField.getText());
                    fullNameLabel.setText("Full name: " + account.getName());
                } else {
                    JOptionPane.showMessageDialog(null, "Error while modifying name. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JPanel passwordPanel = createSubPanel(passwordLabel, passwordField, togglePasswordButton);
        JPanel usernamePanel = createSubPanel(usernameLabel, null, modifyUsernameButton);
        JPanel fullNamePanel = createSubPanel(fullNameLabel, null, modifyFullNameButton);

        // Combine everything into a single panel
        JPanel smallPanel = new JPanel();
        smallPanel.setLayout(new BoxLayout(smallPanel, BoxLayout.Y_AXIS));
        smallPanel.setBackground(new Color(235, 213, 243));
        smallPanel.add(usernamePanel);
        smallPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        smallPanel.add(passwordPanel);
        smallPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        smallPanel.add(fullNamePanel);

        // Add to the main panel
        this.add(smallPanel);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
    }

    // Helper method to create a sub-panel with components
    private JPanel createSubPanel(JLabel label, JComponent centerComponent, JButton button) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(235, 213, 243));
        panel.add(label, BorderLayout.WEST);
        if (centerComponent != null) {
            panel.add(centerComponent, BorderLayout.CENTER);
        }
        panel.add(button, BorderLayout.EAST);
        return panel;
    }
}
