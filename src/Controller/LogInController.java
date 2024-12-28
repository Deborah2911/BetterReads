package Controller;

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
    private LogInView logInViewPage;

    public LogInController(LogInModel logInModel1, LogInView logInViewPage1){
        this.logInModel=logInModel1;
        this.logInViewPage = logInViewPage1;
        logInViewPage.setSignUpButtonActionListener(new SignUpListener());
        logInViewPage.setLogInButtonActionListener(new LogInListener());
        logInViewPage.setVisible(true);
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
            User account = logInModel.checkUsernamePassword(logInViewPage.getUsername(), logInViewPage.getPassword());
            if(account != null){
                ReleasesModel releasesModel = new ReleasesModel();
                ReleasesView releasesView = new ReleasesView(account);
                ReleasesController releasesController = new ReleasesController(releasesModel, releasesView);
                logInViewPage.dispose();
            }
            else{
                logInViewPage.setMessageVisible();
            }
        }
    }
}
