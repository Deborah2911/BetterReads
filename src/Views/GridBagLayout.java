package Views;

import javax.swing.*;
import java.awt.*;

import static java.awt.GridBagConstraints.*;

public class GridBagLayout {
    public static JPanel createPanelReviews(JLabel l1, JLabel l2, JLabel l3, JLabel l4) {
        JPanel panel = new JPanel(new java.awt.GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        //userFullName
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = NORTHWEST;
        gbc.weighty = 0.0;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(10, 5, 5, 0);
        gbc.ipady = 0;
        //l1.setFont(Font.getFont(MONOSPACED));
        l1.setForeground(new Color(75, 37, 100));
        //l1.setFont(Font.getFont(String.valueOf(BOLD)));
        panel.add(l1, gbc);

        //book cover
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = FIRST_LINE_START;
        gbc.weighty = 1.0;
        gbc.weightx = 1.0;
        gbc.ipady = 0;
        gbc.ipadx = 10;
        gbc.gridheight = 2;
        panel.add(l2, gbc);

        //title and author
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = CENTER;
        gbc.gridheight = 1;
        //l3.setFont(Font.getFont(MONOSPACED));
        panel.add(l3, gbc);

        //rating
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = LINE_END;
        gbc.weighty = 0.0;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(0, 0, 30, 10);
        gbc.ipady = 10;
        gbc.ipadx = 10;
        //l4.setBackground(Color.GRAY);
        l4.setForeground(new Color(255, 100, 0));
        //l4.setFont(Font.getFont(String.valueOf(BOLD)));
        panel.add(l4, gbc);

        panel.setPreferredSize(new Dimension(500, 150));
        return panel;
    }

    public static JPanel createReleasesPanel(JLabel l1, JLabel l2, JLabel l3) {
        JPanel panel = new JPanel(new java.awt.GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        //releaseDate
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = NORTHWEST;
        gbc.weighty = 0.0;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(10, 0, 5, 30);
        gbc.ipady = 0;
        l1.setForeground(new Color(130, 50, 100));
        //l1.setFont(Font.getFont(String.valueOf(BOLD)));
        panel.add(l1, gbc);

        //book cover
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = FIRST_LINE_START;
        gbc.weighty = 1.0;
        gbc.weightx = 1.0;
        gbc.ipady = 0;
        gbc.ipadx = 10;
        gbc.gridheight = 2;
        panel.add(l2, gbc);

        //title and author
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = WEST;
        gbc.gridheight = 1;
        //l3.setFont(Font.getFont(MONOSPACED));
        panel.add(l3, gbc);

        panel.setPreferredSize(new Dimension(500, 150));
        return panel;
    }

    public static JPanel createFriendPanel(JLabel fullNameLabel, JLabel usernameLabel) {
        JPanel panel = new JPanel(new java.awt.GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Friend's full name
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.weighty = 0.0;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(10, 5, 5, 0);
        fullNameLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Larger font for the full name
        fullNameLabel.setForeground(new Color(75, 37, 100));
        panel.add(fullNameLabel, gbc);

        // Friend's username
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.weighty = 0.0;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(5, 5, 10, 0);
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Smaller font for the username
        usernameLabel.setForeground(new Color(50, 50, 50)); // Darker color for the username
        panel.add(usernameLabel, gbc);

        panel.setPreferredSize(new Dimension(300, 100)); // Adjust the size as needed
        return panel;
    }

}
