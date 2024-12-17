package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SignUpView extends JFrame {

    private final JLabel title;
    private final JLabel fullNameLabel;
    private final JLabel usernameLabel;
    private final JLabel passwordLabel;
    private final JLabel confirmPasswordLabel;
    private final JLabel messageFullName;
    private final JLabel messageUsername;
    private final JLabel messagePassword;
    private final JLabel messageExistingPassword;

    private JTextField fullNameField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;

    private final JButton signUpButton;

    public SignUpView() {
        title = new JLabel("Sign Up to BetterReads");
        fullNameLabel = new JLabel("Full Name:");
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        confirmPasswordLabel = new JLabel("Confirm password:");
        messageFullName = new JLabel("Full Name not entered!");
        messageUsername = new JLabel("Username already taken or not entered!");
        messagePassword = new JLabel("Passwords do not match!");
        messageExistingPassword = new JLabel("Either or both passwords not entered!");

        fullNameField = new JTextField();
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        confirmPasswordField = new JPasswordField();

        signUpButton = new JButton("Sign Up");

        setTitle("BetterReads");
        setLayout(new GridLayout(14, 1));
        setLocationRelativeTo(null);
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        messageFullName.setForeground(Color.RED);
        messageFullName.setVisible(false);

        messageUsername.setForeground(Color.RED);
        messageUsername.setVisible(false);

        messagePassword.setForeground(Color.RED);
        messagePassword.setVisible(false);

        messageExistingPassword.setForeground(Color.RED);
        messageExistingPassword.setVisible(false);

        add(title);
        add(fullNameLabel);
        add(fullNameField);
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(confirmPasswordLabel);
        add(confirmPasswordField);
        add(signUpButton);
        add(messageFullName);
        add(messageUsername);
        add(messagePassword);
        add(messageExistingPassword);
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword1() {
            return String.valueOf(passwordField.getPassword());
    }

    public String getPassword2() {
        return String.valueOf(confirmPasswordField.getPassword());
    }

    public String getFullName() { return String.valueOf(fullNameField.getText());}

    public void setMessageUsernameVisible() {
        messageUsername.setVisible(true);
    }

    public void setMessagePasswordVisible() {
        messagePassword.setVisible(true);
    }

    public void setMessageFullNameVisible() {
        messageFullName.setVisible(true);
    }

    public void setMessageExistingPasswordVisible() {
        messageExistingPassword.setVisible(true);
    }

    public void setSignUpButtonActionListener(ActionListener actionListener) {
        signUpButton.addActionListener(actionListener);
    }
}
