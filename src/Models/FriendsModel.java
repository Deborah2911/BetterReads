package Models;

import Database.DBConnection;
import Database.User;

import java.util.List;

public class FriendsModel {
    private final User account;

    public FriendsModel(User account) {
        this.account = account;
    }

    public List<User> getFriendsList() {
        return DBConnection.getFriendsByUserId(account.getId());
    }

    public boolean addFriend(String friendUsername) {
        return DBConnection.addFriendship(account.getId(), friendUsername);
    }
}
