package Controller;

import Database.DBConnection;
import Database.User;
import Models.SignUpModel;
import Views.MainView;
import Views.SignUpView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpController {
    private SignUpModel signUpModel;
    private SignUpView signUpView;

    public SignUpController(SignUpModel model, SignUpView view){
        this.signUpModel=model;
        this.signUpView=view;
        signUpView.setSignUpButtonActionListener(new SignUpListener());
        signUpView.setVisible(true);
    }

    private class SignUpListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(signUpModel.checkExistingFullName(signUpView.getFullName())) {
                if(signUpModel.checkExistingUsername(signUpView.getUsername())){
                    if(signUpModel.checkExistingPassword(signUpView.getPassword1()) || signUpModel.checkExistingPassword(signUpView.getPassword2())){
                        if(signUpModel.checkSamePassword(signUpView.getPassword1(), signUpView.getPassword2())) {
                            DBConnection.insertUser(signUpView.getUsername(), signUpView.getPassword1(), signUpView.getUsername());
                            User account = new User(signUpView.getUsername(), signUpView.getPassword1(), signUpView.getFullName());
                            MainView mainView = new MainView();
                            MainController mainController = new MainController(account, mainView);
                            signUpView.dispose();
                            //releasesView.dispose();
                        } else{
                            signUpView.setMessagePasswordVisible();
                        }
                    } else {
                        signUpView.setMessageExistingPasswordVisible();
                    }
                } else{
                    signUpView.setMessageUsernameVisible();
                }
            } else {
                signUpView.setMessageFullNameVisible();
            }
        }
    }

}
