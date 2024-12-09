package Controller;

import Models.ReleasesModel;
import Views.ReleasesView;

public class ReleasesController {

    private ReleasesModel releasesModel;
    private ReleasesView releasesView;

    public ReleasesController(ReleasesModel model, ReleasesView view){
        this.releasesModel=model;
        this.releasesView=view;

        releasesView.setVisible(true);
    }
}
