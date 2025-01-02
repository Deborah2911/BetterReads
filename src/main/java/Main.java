import Controllers.*;
import Models.LogInModel;
import Views.LogInView;
import org.mindrot.jbcrypt.BCrypt;

public class Main {
    public static void main(String[] args) {
        LogInModel model = new LogInModel();
        LogInView view = new LogInView();
        LogInController logInController = new LogInController(model, view);
    }
}