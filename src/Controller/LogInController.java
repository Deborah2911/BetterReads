package Controller;

import Database.DBConnection;
import Database.User;
import Models.LogInModel;
import Models.ReleasesModel;
import Models.SignUpModel;
import Views.LogInView;
import Views.ReleasesView;
import Views.SignUpView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInController {
    private LogInModel logInModel;
    private LogInView logInView;

    public LogInController(LogInModel logInModel1, LogInView logInViewPage1){
        this.logInModel=logInModel1;
        this.logInView = logInViewPage1;
        logInView.setSignUpButtonActionListener(new SignUpListener());
        logInView.setLogInButtonActionListener(new LogInListener());
        logInView.setVisible(true);
    }

    private class SignUpListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            SignUpModel signUpModel = new SignUpModel();
            SignUpView signUpView = new SignUpView();
            SignUpController signUpController = new SignUpController(signUpModel, signUpView);
        }
    }

    private class LogInListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            User account = logInModel.checkUsernamePassword(logInView.getUsername(), logInView.getPassword());
            int userId = DBConnection.getUserIdByUsername(account.getUsername());
            if(userId != -1){
                account.setId(userId);
            }
            if(account != null){
                ReleasesModel releasesModel = new ReleasesModel();
                ReleasesView releasesView = new ReleasesView(account);
                ReleasesController releasesController = new ReleasesController(releasesModel, releasesView);
                logInView.dispose();
            }
            else{
                logInView.setMessageVisible();
            }
        }
    }
}
