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

    public LogInView(){
        title = new JLabel("Log In to BetterReads");
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        message = new JLabel("Invalid username or password!");

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        logInButton = new JButton("Log In");
        signUpButton = new JButton("Sign Up");

        setTitle("BetterReads");
        setLayout(new GridLayout(8, 1));
        //setLocationRelativeTo(null);
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        message.setForeground(Color.RED);
        message.setVisible(false);

        setBackground(new Color(250, 200, 200));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title);
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        logInButton.setSize(new Dimension(100, 40));
        add(logInButton);
        signUpButton.setSize(new Dimension(100, 40));
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

    public void setLogInButtonActionListener(ActionListener actionListener){
        logInButton.addActionListener(actionListener);
    }

    public void setSignUpButtonActionListener(ActionListener actionListener){
        signUpButton.addActionListener(actionListener);
    }
}
