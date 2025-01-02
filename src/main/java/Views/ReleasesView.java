package Views;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import Database.Book;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import static java.awt.GridBagConstraints.*;

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

            JPanel smallPanel = createReleasesPanel(releaseDate, labelImage, titleAuthor);
            smallPanel.setBackground(new Color(255, 227, 198));
            add(smallPanel);

            add(Box.createRigidArea(new Dimension(0, 5)));
        }

        revalidate();
        repaint();
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
}
