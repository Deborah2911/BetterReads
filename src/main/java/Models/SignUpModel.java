package Models;

import Database.DBConnection;
import Database.User;

import java.util.List;

public class SignUpModel {

    public boolean checkExistingFullName(String fullName) {
        return !fullName.isBlank();
    }

    public boolean checkExistingPassword(String password) {
        return !password.isBlank();
    }

    public boolean checkExistingUsername(String username){
        //test using select query if username already exists
        //return false if it exists and true otherwise
        if(username.isBlank())
            return false;

        List<User> users = DBConnection.getUser();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkSamePassword(String password1, String password2){
        return password1 != null && !password1.isBlank() && password1.equals(password2);
    }
}
