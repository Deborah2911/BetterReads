package Controller;

import Models.ReleasesModel;
import Views.ReleasesView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReleasesController {

    private ReleasesModel releasesModel;
    private ReleasesView releasesView;

    public ReleasesController(ReleasesModel model, ReleasesView view){
        this.releasesModel=model;
        this.releasesView=view;
        //releasesView.setAccountButtonActionListener(new AccountListener());
        //releasesView.setVisible(true);
    }

    public class AccountListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }
}
