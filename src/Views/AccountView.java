package Views;

import javax.swing.*;
import javax.swing.border.SoftBevelBorder;
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

    private final Color backgroundColor = new Color(230, 255, 255);
    private final Color buttonColor = new Color(235, 213, 243);
    private final Font buttonFont = new Font(Font.SANS_SERIF, Font.PLAIN, 14);

    public AccountView() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);

        fullNameLabel = new JLabel();
        usernameLabel = new JLabel();
        JLabel passwordLabel = new JLabel("Password: ");

        passwordField = new JPasswordField();
        passwordField.setEchoChar('•');
        passwordField.setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
        passwordField.setForeground(new Color(75, 37, 100));
        passwordField.setEditable(false);

        togglePasswordButton = new JButton("Show");
        togglePasswordButton.setBackground(buttonColor);
        togglePasswordButton.setFont(buttonFont);

        modifyUsernameButton = new JButton("Modify Username");
        modifyUsernameButton.setBackground(buttonColor);
        modifyUsernameButton.setFont(buttonFont);

        modifyFullNameButton = new JButton("Modify Full Name");
        modifyFullNameButton.setBackground(buttonColor);
        modifyFullNameButton.setFont(buttonFont);

        logOutButton = new JButton("Log Out");
        logOutButton.setBackground(buttonColor);
        logOutButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));

        JPanel passwordPanel;
        JPanel usernamePanel;
        JPanel fullNamePanel;

        usernamePanel = GridBagLayout.createAccountPanel(usernameLabel, modifyUsernameButton, null);
        passwordPanel = GridBagLayout.createAccountPanel(passwordLabel, togglePasswordButton, passwordField);
        fullNamePanel = GridBagLayout.createAccountPanel(fullNameLabel, modifyFullNameButton, null);

        JPanel smallPanel = new JPanel();
        smallPanel.setLayout(new BoxLayout(smallPanel, BoxLayout.Y_AXIS));
        smallPanel.setBackground(Color.WHITE);
        usernamePanel.setBackground(backgroundColor);
        smallPanel.add(usernamePanel);
        smallPanel.add(Box.createRigidArea(new Dimension(0, 3)));
        passwordPanel.setBackground(backgroundColor);
        smallPanel.add(passwordPanel);
        smallPanel.add(Box.createRigidArea(new Dimension(0, 3)));
        fullNamePanel.setBackground(backgroundColor);
        smallPanel.add(fullNamePanel);

        this.setBackground(backgroundColor);
        this.add(smallPanel);
        this.add(Box.createRigidArea(new Dimension(0, 3)));
        logOutButton.setPreferredSize(new Dimension(90, 50));
        this.add(logOutButton);
    }

    public void setFullNameLabel(String text) {
        fullNameLabel.setText("Full name:       " + text);
    }

    public void setUsernameLabel(String text) {
        usernameLabel.setText("Username:       " + text);
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
