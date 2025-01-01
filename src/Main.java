import Controller.*;
import Models.LogInModel;
import Views.LogInView;

public class Main {
    public static void main(String[] args) {
        LogInModel model = new LogInModel();
        LogInView view = new LogInView();
        LogInController logInController = new LogInController(model, view);
//        ReleasesView view = new ReleasesView();
//        ReleasesModel model = new ReleasesModel();
//        ReleasesController ctrl = new ReleasesController(model, view);
    }
}