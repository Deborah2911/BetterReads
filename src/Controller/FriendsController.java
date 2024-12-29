package Controller;

import Database.User;
import Models.FriendsModel;
import Views.FriendsView;

import javax.swing.*;

public class FriendsController {
    private final FriendsModel model;
    private final FriendsView view;

    public FriendsController(User account, FriendsView view) {
        this.model = new FriendsModel(account);
        this.view = view;

        populateFriendsList();
        view.getAddFriendButton().addActionListener(e -> addFriend());
    }

    private void populateFriendsList() {
        model.getFriendsList().forEach(friend -> {
            String name = friend.getName();
            String username = friend.getUsername();
            view.addFriend(name, username);
        });
    }

    private void addFriend() {
        // Show input dialog for entering friend's username
        String friendUsername = JOptionPane.showInputDialog(view,
                "Enter friend's username:", "Add Friend", JOptionPane.PLAIN_MESSAGE);

        if (friendUsername != null && !friendUsername.trim().isEmpty()) {
            // Attempt to add the friend in the database
            boolean success = model.addFriend(friendUsername.trim());
            if (success) {
                JOptionPane.showMessageDialog(view,
                        "Friend added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                populateFriendsList(); // Refresh the friends list
            } else {
                JOptionPane.showMessageDialog(view,
                        "Failed to add friend. Check the username and try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
