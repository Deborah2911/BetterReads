package Views;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import Database.Reviews;

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

            ImageIcon image = new ImageIcon("C:\\Users\\Denisa\\Downloads\\No_Cover.jpg");
            Image scaledImage = image.getImage().getScaledInstance(100, 140, Image.SCALE_SMOOTH);
            JLabel labelImage = new JLabel(new ImageIcon(scaledImage));

            JPanel smallPanel = GridBagLayout.createPanelReviews(userFullName, labelImage, titleAuthor, rating);
            smallPanel.setBackground(new Color(235, 213, 243));
            add(smallPanel);

            add(Box.createRigidArea(new Dimension(0, 5)));
        }

        revalidate();
        repaint();
    }
}
