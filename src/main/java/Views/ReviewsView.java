package Views;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import Database.Reviews;

import static java.awt.GridBagConstraints.*;
import static java.awt.GridBagConstraints.LINE_END;

public class ReviewsView extends JPanel {
    public ReviewsView() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);
    }

    public void updateReviews(List<Reviews> reviewsList) {
        removeAll(); // Clear existing content

        for (Reviews review : reviewsList) {
            JLabel titleAuthor = new JLabel(review.getTitle() + "    by     " + review.getAuthor());
            JLabel userFullName = new JLabel(review.getUserFullName() + " reviewed ");
            JLabel rating = new JLabel(review.getRating() + "/5 stars ");

            ImageIcon format = new ImageIcon(review.getImgBytes());
            Image scaledImage = format.getImage().getScaledInstance(100, 140, Image.SCALE_SMOOTH);
            JLabel labelImage = new JLabel(new ImageIcon(scaledImage));

            JPanel smallPanel = createPanelReviews(userFullName, labelImage, titleAuthor, rating);
            smallPanel.setBackground(new Color(235, 213, 243));
            add(smallPanel);

            add(Box.createRigidArea(new Dimension(0, 5)));
        }

        revalidate();
        repaint();
    }

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
}
