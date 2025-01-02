package Views;

import javax.swing.*;
import javax.swing.border.TitledBorder;
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
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(255, 248, 238)); // Soft pastel background

        // Labels and Password Field
        fullNameLabel = new JLabel("John Doe");
        usernameLabel = new JLabel("johndoe");
        JLabel passwordLabel = new JLabel("Password: ");

        passwordField = new JPasswordField();
        passwordField.setEchoChar('•');
        passwordField.setFont(new Font(Font.MONOSPACED, Font.BOLD, 16));
        passwordField.setForeground(new Color(93, 64, 55)); // Subtle brown color
        passwordField.setEditable(false);

        // Buttons
        togglePasswordButton = createButton("Show", new Color(207, 250, 244), new Color(0, 121, 107));
        modifyUsernameButton = createButton("Modify Username", new Color(207, 250, 244), new Color(0, 121, 107));
        modifyFullNameButton = createButton("Modify Full Name", new Color(207, 250, 244), new Color(0, 121, 107));
        logOutButton = createButton("Log Out", new Color(255, 235, 238), new Color(183, 28, 28));

        // Panels for organized layout
        JPanel passwordPanel = createSubPanel("Password", passwordField, togglePasswordButton);
        JPanel usernamePanel = createSubPanel("Username", usernameLabel, modifyUsernameButton);
        JPanel fullNamePanel = createSubPanel("Full name", fullNameLabel, modifyFullNameButton);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(new Color(255, 248, 238));
        contentPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(209, 196, 233), 1), // Light purple border
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        contentPanel.add(fullNamePanel);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        contentPanel.add(usernamePanel);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        contentPanel.add(passwordPanel);

        // Adding components to the main panel
        this.add(contentPanel);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(logOutButton);
    }

    private JButton createButton(String text, Color bgColor, Color fgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        return button;
    }

    private JPanel createSubPanel(String name, JComponent field, JButton button) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(209, 196, 233), 1), // Light purple
                        BorderFactory.createEmptyBorder(10, 10, 10, 10)
                ),
                name,
                TitledBorder.LEFT, // Title alignment
                TitledBorder.TOP,  // Title position
                new Font("Arial", Font.BOLD, 14), // Title font
                new Color(85, 85, 85) // Title color
        ));
        panel.setBackground(new Color(232, 234, 246)); // Very light purple

        GridBagConstraints gbc = new GridBagConstraints();

        if (field != null) {
            field.setBorder(BorderFactory.createLineBorder(new Color(209, 196, 233), 1)); // Light purple
            field.setPreferredSize(new Dimension(200, 30));
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 1;
            panel.add(field, gbc);
        }

        if (button != null) {
            button.setPreferredSize(new Dimension(150, 30));
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.gridwidth = 1;
            panel.add(button, gbc);
        }

        return panel;
    }

    public void setFullNameLabel(String text) {
        fullNameLabel.setText(text);
    }

    public void setUsernameLabel(String text) {
        usernameLabel.setText(text);
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
