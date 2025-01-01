package Views;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import Database.Book;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class ReleasesView extends JPanel {
    public ReleasesView() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);
    }

    public void updateReleases(List<Book> releasesList) {
        removeAll(); // Clear any existing content
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

        for (Book release : releasesList) {
            SimpleDateFormat ft2 = new SimpleDateFormat("dd-MM-yyyy");
            String bookReleaseDate = ft2.format(release.getReleaseDate());

            JLabel titleAuthor = new JLabel(release.getTitle() + "    by    " + release.getAuthor());
            JLabel releaseDate = new JLabel("Releases " + bookReleaseDate + " :");

            ImageIcon image = new ImageIcon("C:\\Users\\Denisa\\Downloads\\No_Cover.jpg");
            Image scaledImage = image.getImage().getScaledInstance(100, 140, Image.SCALE_SMOOTH);
            JLabel labelImage = new JLabel(new ImageIcon(scaledImage));

            JPanel smallPanel = GridBagLayout.createReleasesPanel(releaseDate, labelImage, titleAuthor);
            smallPanel.setBackground(new Color(255, 227, 198));
            add(smallPanel);

            add(Box.createRigidArea(new Dimension(0, 5)));
        }

        revalidate();
        repaint();
    }
}
