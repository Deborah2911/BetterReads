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

    private final JButton logInButton;
    private final JButton signUpButton;

    public SignUpView() {
        // Initialize components
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

        logInButton = new JButton("Log In");
        signUpButton = new JButton("Sign Up");

        // JFrame setup
        setTitle("BetterReads");
        setLayout(new GridLayout(15, 1, 10, 10)); // Added spacing between rows
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Background color
        getContentPane().setBackground(new Color(245, 240, 255)); // Soft lavender

        // Title styling
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setForeground(new Color(120, 90, 160)); // Darker pastel purple

        // Label styling
        fullNameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        fullNameLabel.setForeground(new Color(80, 80, 120)); // Subtle purple-gray
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        usernameLabel.setForeground(new Color(80, 80, 120)); // Subtle purple-gray
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        passwordLabel.setForeground(new Color(80, 80, 120)); // Subtle purple-gray
        confirmPasswordLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        confirmPasswordLabel.setForeground(new Color(80, 80, 120)); // Subtle purple-gray

        // Input field styling
        fullNameField.setBackground(new Color(255, 250, 255)); // Soft white-lavender
        fullNameField.setBorder(BorderFactory.createLineBorder(new Color(180, 160, 220), 1)); // Light purple border
        usernameField.setBackground(new Color(255, 250, 255)); // Soft white-lavender
        usernameField.setBorder(BorderFactory.createLineBorder(new Color(180, 160, 220), 1)); // Light purple border
        passwordField.setBackground(new Color(255, 250, 255)); // Soft white-lavender
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(180, 160, 220), 1)); // Light purple border
        confirmPasswordField.setBackground(new Color(255, 250, 255)); // Soft white-lavender
        confirmPasswordField.setBorder(BorderFactory.createLineBorder(new Color(180, 160, 220), 1)); // Light purple border

        // Message label styling
        messageFullName.setForeground(new Color(200, 80, 80)); // Pastel red
        messageFullName.setFont(new Font("Arial", Font.PLAIN, 14));
        messageFullName.setHorizontalAlignment(SwingConstants.CENTER);
        messageFullName.setVisible(false);

        messageUsername.setForeground(new Color(200, 80, 80)); // Pastel red
        messageUsername.setFont(new Font("Arial", Font.PLAIN, 14));
        messageUsername.setHorizontalAlignment(SwingConstants.CENTER);
        messageUsername.setVisible(false);

        messagePassword.setForeground(new Color(200, 80, 80)); // Pastel red
        messagePassword.setFont(new Font("Arial", Font.PLAIN, 14));
        messagePassword.setHorizontalAlignment(SwingConstants.CENTER);
        messagePassword.setVisible(false);

        messageExistingPassword.setForeground(new Color(200, 80, 80)); // Pastel red
        messageExistingPassword.setFont(new Font("Arial", Font.PLAIN, 14));
        messageExistingPassword.setHorizontalAlignment(SwingConstants.CENTER);
        messageExistingPassword.setVisible(false);

        // Button styling
        logInButton.setBackground(new Color(180, 220, 240)); // Soft pastel blue
        logInButton.setForeground(Color.WHITE);
        logInButton.setFont(new Font("Arial", Font.BOLD, 16));
        logInButton.setFocusPainted(false);
        logInButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        signUpButton.setBackground(new Color(240, 180, 220)); // Soft pastel pink
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setFont(new Font("Arial", Font.BOLD, 16));
        signUpButton.setFocusPainted(false);
        signUpButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add components to JFrame
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
        add(logInButton);
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

    public String getFullName() {
        return String.valueOf(fullNameField.getText());
    }

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

    public void setLogInButtonActionListener(ActionListener actionListener) {
        logInButton.addActionListener(actionListener);
    }
}
