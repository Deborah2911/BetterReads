package Models;

import Database.DBConnection;
import Database.PasswordHashing;
import Database.User;

import java.util.List;

public class LogInModel {

    public User checkUsernamePassword(String username, String plainPassword) {
        List<User> users = DBConnection.getUser();
        for (User user : users) {
            if (user.getUsername().equals(username) && PasswordHashing.verifyPassword(plainPassword, user.getPassword())) {
                user.setPassword(plainPassword);
                return user;
            }
        }
        return null;
    }
}
