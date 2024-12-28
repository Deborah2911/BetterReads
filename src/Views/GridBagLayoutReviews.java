package Views;

import javax.swing.*;
import java.awt.*;

import static java.awt.Font.BOLD;
import static java.awt.Font.MONOSPACED;
import static java.awt.GridBagConstraints.*;

public class GridBagLayoutReviews {
    public static JPanel createPanel(JLabel l1, JLabel l2, JLabel l3, JLabel l4) {
        JPanel panel = new JPanel(new GridBagLayout());
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
        JPanel panel = new JPanel(new GridBagLayout());
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

    public static JPanel createAccountPanel(JLabel username, JLabel password, JLabel fullName) {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Common label settings
        Font labelFont = new Font(Font.MONOSPACED, Font.BOLD, 18); // Larger font
        Color labelColor = new Color(75, 37, 100); // Dark purple

        // Username Label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST; // Align to the left
        gbc.weightx = 1.0; // Take up horizontal space
        gbc.insets = new Insets(10, 10, 5, 10); // Padding
        username.setFont(labelFont);
        username.setForeground(labelColor);
        panel.add(username, gbc);

        // Password Label
        gbc.gridy = 1; // Move to the next row
        password.setFont(labelFont);
        password.setForeground(labelColor);
        panel.add(password, gbc);

        // Full Name Label
        gbc.gridy = 2; // Move to the next row
        fullName.setFont(labelFont);
        fullName.setForeground(labelColor);
        panel.add(fullName, gbc);

        // Set panel properties
        panel.setBackground(new Color(235, 213, 243)); // Light purple background
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); // Padding inside the panel
        panel.setPreferredSize(new Dimension(500, 200)); // Adjust size as needed

        return panel;
    }
}
