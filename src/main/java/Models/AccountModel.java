package Models;

import Database.DBConnection;
import Database.User;

public class AccountModel {
    private User account;
    public AccountModel(User account) {
        this.account = account;
    }

    public String getFullName() {
        return account.getName();
    }

    public void setFullName(String fullName) {
        if (DBConnection.modifyName(account.getName(), fullName)) {
            account.setName(fullName);
        }
    }

    public String getUsername() {
        return account.getUsername();
    }

    public void setUsername(String username) {
        if (DBConnection.modifyUsername(account.getUsername(), username)) {
            account.setUsername(username);
        }
    }

    public String getPassword() {
        return account.getPassword();
    }
}
