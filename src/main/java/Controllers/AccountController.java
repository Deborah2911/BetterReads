package Controllers;

import Database.User;
import Models.AccountModel;
import Models.LogInModel;
import Views.AccountView;
import Views.LogInView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountController {
    private AccountModel model;
    private AccountView view;

    public AccountController(User account, AccountView view) {
        this.model = new AccountModel(account);
        this.view = view;

        updateView();

        view.setTogglePasswordActionListener(new TogglePasswordActionListener());
        view.setModifyUsernameActionListener(new ModifyUsernameActionListener());
        view.setModifyFullNameActionListener(new ModifyFullNameActionListener());
        view.setLogOutActionListener(new LogOutActionListener());
    }

    private void updateView() {
        view.setFullNameLabel(model.getFullName());
        view.setUsernameLabel(model.getUsername());
        view.setPasswordField(model.getPassword());
    }

    private class TogglePasswordActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JPasswordField passwordField = view.getPasswordField();
            JButton toggleButton = view.getTogglePasswordButton();
            if (passwordField.getEchoChar() == '•') {
                passwordField.setEchoChar((char) 0);
                toggleButton.setText("Hide");
            } else {
                passwordField.setEchoChar('•');
                toggleButton.setText("Show");
            }
        }
    }

    private class LogOutActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            SwingUtilities.getWindowAncestor(view).dispose();
            LogInView logInView = new LogInView();
            LogInModel logInModel = new LogInModel();
            LogInController logInController = new LogInController(logInModel, logInView);
        }
    }

    private class ModifyUsernameActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JTextField usernameField = new JTextField(model.getUsername(), 20);
            int result = JOptionPane.showConfirmDialog(null, usernameField, "Modify Username", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                String newUsername = usernameField.getText();
                model.setUsername(newUsername);
                updateView();
            }
        }
    }

    private class ModifyFullNameActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JTextField fullNameField = new JTextField(model.getFullName(), 20);
            int result = JOptionPane.showConfirmDialog(null, fullNameField, "Modify Full Name", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                String newFullName = fullNameField.getText();
                model.setFullName(newFullName);
                updateView();
            }
        }
    }
}
