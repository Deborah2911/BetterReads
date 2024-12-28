package Views;

import Database.DBConnection;
import Database.User;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FriendsPanel extends JScrollPane {
    public FriendsPanel(User account) {
        // Create the friends panel with BoxLayout
        JPanel friendsPanel = new JPanel();
        friendsPanel.setLayout(new BoxLayout(friendsPanel, BoxLayout.Y_AXIS));
        friendsPanel.setBackground(Color.WHITE); // Matching background color for the panel

        // Fetch the list of friends from the database
        List<User> friendsList = DBConnection.getFriendsByUserId(account.getId());

        // Iterate through the friends and create small panels
        for (User friend : friendsList) {
            JLabel friendUsername = new JLabel(friend.getUsername());
            JLabel friendName = new JLabel(friend.getName());

            JPanel smallPanel = GridBagLayoutReviews.createFriendPanel(friendName, friendUsername);
            smallPanel.setBackground(new Color(255, 227, 198)); // Same color as the releases panel
            friendsPanel.add(smallPanel);

            friendsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        }

        // Set the content pane of the JScrollPane (the panel containing all friends)
        setViewportView(friendsPanel); // This sets the scrollable content of the JScrollPane

        // Set properties for the JScrollPane
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        getVerticalScrollBar().setUnitIncrement(16);
    }
}
