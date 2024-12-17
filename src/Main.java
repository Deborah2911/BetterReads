import Controller.*;
import Database.Book;
import Database.DBConnection;
import Models.LogInModel;
import Views.LogInView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LogInModel model = new LogInModel();
        LogInView view = new LogInView();
        LogInController logInController = new LogInController(model, view);
    }
}