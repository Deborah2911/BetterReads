package Views;

import javax.swing.*;
import java.awt.*;

public class AccountView extends JFrame {
    private final JLabel title = new JLabel("My Account");
    private final JLabel nameLabel = new JLabel("Full Name:");
    private final JLabel usernameLabel = new JLabel("Username:");
    private final JLabel passwordLabel =  new JLabel("Password:");

    private JLabel name = new JLabel("Name");
    private JLabel pass = new JLabel("Password");
    private JLabel user = new JLabel("Username");

    public AccountView() {
        name = new JLabel();
        pass = new JLabel();
        user = new JLabel();

        setTitle("BetterReads");
        setLayout(new GridLayout(8, 1));
        setLocationRelativeTo(null);
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(title);
        add(nameLabel);
        add(name);
        add(usernameLabel);
        add(user);
        add(passwordLabel);
        add(pass);
    }

    public void setAccountDetails(String fullName, String username, String password) {
        name.setText(fullName);
        user.setText(username);
        pass.setText(password);
    }

    public String getName() {
        return name.getText();
    }

    public String getPassword() {
        return pass.getText();
    }

    public String getUsername() {
        return user.getText();
    }
}
