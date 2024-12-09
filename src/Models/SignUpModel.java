package Models;

public class SignUpModel {

    public boolean checkExistingUsername(String username){
        //test using select query if username already exists
        //return false if it exists and true otherwise
        if(username.isBlank())
            return false;
        return true;
    }

    public boolean checkSamePassword(String password1, String password2){
        return password1 != null && !password1.isBlank() && password1.equals(password2);
    }
}
