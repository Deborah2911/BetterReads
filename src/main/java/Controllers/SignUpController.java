package Controllers;

import Database.DBConnection;
import Database.User;
import Models.LogInModel;
import Models.SignUpModel;
import Views.LogInView;
import Views.MainView;
import Views.SignUpView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpController {
    private final SignUpModel model;
    private final SignUpView view;

    public SignUpController(SignUpModel model, SignUpView view){
        this.model =model;
        this.view =view;
        this.view.setLogInButtonActionListener(new LogInListener());
        this.view.setSignUpButtonActionListener(new SignUpListener());
        this.view.setVisible(true);
    }

    private class LogInListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            LogInModel model = new LogInModel();
            LogInView view = new LogInView();
            LogInController logInController = new LogInController(model, view);
            SignUpController.this.view.dispose();
        }
    }

    private class SignUpListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(model.checkExistingFullName(view.getFullName())) {
                if(model.checkExistingUsername(view.getUsername())){
                    if(model.checkExistingPassword(view.getPassword1()) || model.checkExistingPassword(view.getPassword2())){
                        if(model.checkSamePassword(view.getPassword1(), view.getPassword2())) {
                            DBConnection.insertUser(view.getUsername(), view.getPassword1(), view.getFullName());
                            User account = new User(view.getUsername(), view.getPassword1(), view.getFullName());
                            int userId = DBConnection.getUserIdByUsername(account.getUsername());
                            if(userId != -1){
                                account.setId(userId);
                            }
                            MainView mainView = new MainView();
                            MainController mainController = new MainController(account, mainView);
                            view.dispose();
                            //releasesView.dispose();
                        } else{
                            view.setMessagePasswordVisible();
                        }
                    } else {
                        view.setMessageExistingPasswordVisible();
                    }
                } else{
                    view.setMessageUsernameVisible();
                }
            } else {
                view.setMessageFullNameVisible();
            }
        }
    }

}
