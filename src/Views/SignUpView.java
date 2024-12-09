package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SignUpView extends JFrame {

    private final JLabel title;
    private final JLabel usernameLabel;
    private final JLabel passwordLabel;
    private final JLabel confirmPasswordLabel;
    private final JLabel messageUsername;
    private final JLabel messagePassword;

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;

    private final JButton signUpButton;

    public SignUpView() {
        title = new JLabel("Sign Up to BetterReads");
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        confirmPasswordLabel = new JLabel("Confirm password:");
        messageUsername = new JLabel("Username already taken!");
        messagePassword = new JLabel("Passwords do not match!");

        usernameField = new JTextField();
        passwordField = new JPasswordField();
        confirmPasswordField = new JPasswordField();

        signUpButton = new JButton("Sign Up");

        setTitle("BetterReads");
        setLayout(new GridLayout(10, 1));
        setLocationRelativeTo(null);
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        messageUsername.setForeground(Color.RED);
        messageUsername.setVisible(false);

        messagePassword.setForeground(Color.RED);
        messagePassword.setVisible(false);

        add(title);
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(confirmPasswordLabel);
        add(confirmPasswordField);
        add(signUpButton);
        add(messageUsername);
        add(messagePassword);
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

    public void setMessageUsernameVisible() {
        messageUsername.setVisible(true);
    }

    public void setMessagePasswordVisible() {
        messagePassword.setVisible(true);
    }

    public void setSignUpButtonActionListener(ActionListener actionListener) {
        signUpButton.addActionListener(actionListener);
    }
}
