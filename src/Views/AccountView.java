package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AccountView extends JPanel {
    private JLabel fullNameLabel;
    private JLabel usernameLabel;
    private JPasswordField passwordField;
    private JButton togglePasswordButton;
    private JButton modifyUsernameButton;
    private JButton modifyFullNameButton;
    private JButton logOutButton;

    public AccountView() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.WHITE);

        fullNameLabel = new JLabel();
        usernameLabel = new JLabel();
        JLabel passwordLabel = new JLabel("Password: ");

        passwordField = new JPasswordField();
        passwordField.setEchoChar('•');
        passwordField.setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
        passwordField.setForeground(new Color(75, 37, 100));
        passwordField.setEditable(false);

        togglePasswordButton = new JButton("Show");
        togglePasswordButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));

        modifyUsernameButton = new JButton("Modify Username");
        modifyUsernameButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));

        modifyFullNameButton = new JButton("Modify Full Name");
        modifyFullNameButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));

        logOutButton = new JButton("Log Out");
        logOutButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));

        JPanel passwordPanel = createSubPanel(passwordLabel, passwordField, togglePasswordButton);
        JPanel usernamePanel = createSubPanel(usernameLabel, null, modifyUsernameButton);
        JPanel fullNamePanel = createSubPanel(fullNameLabel, null, modifyFullNameButton);

        JPanel smallPanel = new JPanel();
        smallPanel.setLayout(new BoxLayout(smallPanel, BoxLayout.Y_AXIS));
        smallPanel.setBackground(new Color(235, 213, 243));
        smallPanel.add(usernamePanel);
        smallPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        smallPanel.add(passwordPanel);
        smallPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        smallPanel.add(fullNamePanel);

        this.add(smallPanel);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(logOutButton);
    }

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

    public void setFullNameLabel(String text) {
        fullNameLabel.setText("Full name: " + text);
    }

    public void setUsernameLabel(String text) {
        usernameLabel.setText("Username: " + text);
    }

    public void setPasswordField(String text) {
        passwordField.setText(text);
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void setTogglePasswordActionListener(ActionListener actionListener) {
        togglePasswordButton.addActionListener(actionListener);
    }

    public void setModifyUsernameActionListener(ActionListener actionListener) {
        modifyUsernameButton.addActionListener(actionListener);
    }

    public void setModifyFullNameActionListener(ActionListener actionListener) {
        modifyFullNameButton.addActionListener(actionListener);
    }

    public void setLogOutActionListener(ActionListener actionListener) {
        logOutButton.addActionListener(actionListener);
    }

    public JButton getTogglePasswordButton() {
        return togglePasswordButton;
    }
}
