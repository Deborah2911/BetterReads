package Controller;

import Models.ReleasesModel;
import Models.SignUpModel;
import Views.ReleasesView;
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
            if(signUpModel.checkExistingUsername(signUpView.getUsername())){
                if(signUpModel.checkSamePassword(signUpView.getPassword1(), signUpView.getPassword2())) {
                    DBConnection.insertUser(signUpView.getUsername(), signUpView.getPassword1(), signUpView.getUsername());
                    ReleasesModel releasesModel = new ReleasesModel();
                    ReleasesView releasesView = new ReleasesView();
                    ReleasesController releasesController = new ReleasesController(releasesModel, releasesView);
                } else{
                    signUpView.setMessagePasswordVisible();
                }
            } else{
                signUpView.setMessageUsernameVisible();
            }
        }
    }

}
