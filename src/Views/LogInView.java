package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LogInView extends JFrame {
    private final JLabel title;
    private final JLabel usernameLabel;
    private final JLabel passwordLabel;
    private final JLabel message;

    private JTextField usernameField;
    private JPasswordField passwordField;

    private final JButton logInButton;
    private final JButton signUpButton;

    public LogInView() {
        // Initialize components
        title = new JLabel("Log In to BetterReads");
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        message = new JLabel("Invalid username or password!");

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        logInButton = new JButton("Log In");
        signUpButton = new JButton("Sign Up");

        // JFrame setup
        setTitle("BetterReads");
        setLayout(new GridLayout(8, 1, 10, 10)); // Added spacing between rows
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Background color
        getContentPane().setBackground(new Color(245, 240, 255)); // Soft lavender

        // Title styling
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setForeground(new Color(120, 90, 160)); // Darker pastel purple

        // Label styling
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        usernameLabel.setForeground(new Color(80, 80, 120)); // Subtle purple-gray
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        passwordLabel.setForeground(new Color(80, 80, 120)); // Subtle purple-gray

        // Input field styling
        usernameField.setBackground(new Color(255, 250, 255)); // Soft white-lavender
        usernameField.setBorder(BorderFactory.createLineBorder(new Color(180, 160, 220), 1)); // Light purple border
        passwordField.setBackground(new Color(255, 250, 255)); // Soft white-lavender
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(180, 160, 220), 1)); // Light purple border

        // Message label styling
        message.setForeground(new Color(200, 80, 80)); // Pastel red
        message.setFont(new Font("Arial", Font.PLAIN, 14));
        message.setHorizontalAlignment(SwingConstants.CENTER);
        message.setVisible(false);

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
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(logInButton);
        add(signUpButton);
        add(message);
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return String.valueOf(passwordField.getPassword());
    }

    public void setMessageVisible() {
        message.setVisible(true);
    }

    public void setLogInButtonActionListener(ActionListener actionListener) {
        logInButton.addActionListener(actionListener);
    }

    public void setSignUpButtonActionListener(ActionListener actionListener) {
        signUpButton.addActionListener(actionListener);
    }
}
