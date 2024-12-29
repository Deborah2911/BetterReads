package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FriendsView extends JPanel {
    private final JPanel friendsPanel;
    private final JButton addFriendButton;

    public FriendsView() {
        // Set layout for the main FriendsView
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Initialize the main panel with vertical layout
        friendsPanel = new JPanel();
        friendsPanel.setLayout(new BoxLayout(friendsPanel, BoxLayout.Y_AXIS));
        friendsPanel.setBackground(Color.WHITE);

        // Configure the JScrollPane for the friends list
        JScrollPane scrollPane = new JScrollPane(friendsPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        // Add the JScrollPane to the center of the BorderLayout
        add(scrollPane, BorderLayout.CENTER);

        // Create the bottom panel for the "Add Friend" button
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setBackground(new Color(240, 240, 240)); // Optional: distinct background color

        // Initialize the "Add Friend" button
        addFriendButton = new JButton("Add Friend");
        bottomPanel.add(addFriendButton);

        // Add the bottom panel to the BorderLayout at the bottom
        add(bottomPanel, BorderLayout.SOUTH);
    }

    public void setAddFriendButtonActionListener(ActionListener actionListener) {
        addFriendButton.addActionListener(actionListener);
    }

    public void addFriend(String name, String username) {
        JLabel friendName = new JLabel(name);
        JLabel friendUsername = new JLabel(username);

        JPanel friendPanel = createFriendPanel(friendName, friendUsername);
        friendPanel.setBackground(new Color(255, 227, 198));

        friendsPanel.add(friendPanel);
        friendsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        friendsPanel.revalidate();
        friendsPanel.repaint();
    }

    private JPanel createFriendPanel(JLabel nameLabel, JLabel usernameLabel) {
        JPanel panel = new JPanel(new java.awt.GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Set up GridBagLayout for the name label
        gbc.gridx = 0;  // Column 0
        gbc.gridy = 0;  // Row 0
        gbc.anchor = GridBagConstraints.WEST;  // Align to the left
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));  // Larger font for name
        panel.add(nameLabel, gbc);

        // Set up GridBagLayout for the username label
        gbc.gridx = 0;  // Column 0
        gbc.gridy = 1;  // Row 1
        gbc.anchor = GridBagConstraints.WEST;  // Align to the left
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 12));  // Smaller font for username
        panel.add(usernameLabel, gbc);

        return panel;
    }


}
