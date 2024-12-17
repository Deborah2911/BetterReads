package Controller;

import Models.LogInModel;
import Models.ReleasesModel;
import Models.SignUpModel;
import Views.AccountView;
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

            if(logInModel.checkUsernamePassword(logInViewPage.getUsername(), logInViewPage.getPassword())){
                ReleasesModel releasesModel = new ReleasesModel();
                ReleasesView releasesView = new ReleasesView();
                ReleasesController releasesController = new ReleasesController(releasesModel, releasesView);
                AccountView accountView = new AccountView();
                accountView.setAccountDetails(logInViewPage.getName(), logInViewPage.getUsername(), logInViewPage.getPassword());
                //find out how to close this page when moving to another
            }
            else{
                logInViewPage.setMessageVisible();
            }
        }
    }
}
