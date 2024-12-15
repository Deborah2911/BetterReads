package Models;

import Controller.DBConnection;
import Controller.User;

import java.util.List;

public class LogInModel {

    public boolean checkUsernamePassword(String username, String password){
        List<User> users = DBConnection.getUser();
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
