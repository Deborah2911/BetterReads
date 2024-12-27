import Controller.*;
import Database.Book;
import Database.DBConnection;
import Models.LogInModel;
import Models.ReleasesModel;
import Views.LogInView;
import Views.ReleasesView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        LogInModel model = new LogInModel();
//        LogInView view = new LogInView();
//        LogInController logInController = new LogInController(model, view);
        ReleasesView view = new ReleasesView();
        ReleasesModel model = new ReleasesModel();
        ReleasesController ctrl = new ReleasesController(model, view);
    }
}