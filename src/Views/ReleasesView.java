package Views;

import Controller.AccountController;
import Controller.FriendsController;
import Database.Book;
import Database.DBConnection;
import Database.Reviews;
import Database.User;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReleasesView extends JFrame {
    public ReleasesView(User account){
        // Main panel
        final JFrame frame = new JFrame("BetterReads");

        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Reviews panel
        JPanel reviewsPanel = new JPanel();
        reviewsPanel.setLayout(new BoxLayout(reviewsPanel, BoxLayout.Y_AXIS));
        reviewsPanel.setBackground(Color.WHITE);

        List<Reviews> reviewsList = new ArrayList<>();
        reviewsList = DBConnection.getReviews();

        for(Reviews review: reviewsList) {
            JLabel titleAuthor = new JLabel(review.getTitle()+"   by  "+review.getAuthor());
            JLabel userFullName = new JLabel(review.getUserFullName()+" reviewed ");
            JLabel rating = new JLabel(review.getRating()+"/5 stars ");

            ImageIcon image = new ImageIcon("D:\\Facultate\\Anul_2\\OOP\\BetterReads\\reviews_page.png");
            Image scaledImage = image.getImage().getScaledInstance(100, 140, Image.SCALE_SMOOTH);
            JLabel labelImage = new JLabel(new ImageIcon(scaledImage));

            JPanel smallPanel = GridBagLayout.createPanelReviews(userFullName, labelImage, titleAuthor, rating);
            smallPanel.setBackground(new Color(235, 213, 243));
            reviewsPanel.add(smallPanel);

            reviewsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        }

        JScrollPane scrollPane = new JScrollPane(reviewsPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        tabbedPane.addTab("Reviews", scrollPane);


        // Releases panel
        JPanel releasesPanel = new JPanel();
        releasesPanel.setLayout(new BoxLayout(releasesPanel, BoxLayout.Y_AXIS));
        releasesPanel.setBackground(Color.WHITE);
        List<Book> releasesList = new ArrayList<>();
        releasesList = DBConnection.getBook();

        for(Book release: releasesList) {
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
            String bookReleaseDate = ft.format(release.getReleaseDate());
            String monthYear = bookReleaseDate.substring(0, 7);
            String currentDate = LocalDate.now().toString();
            String currentMonthYear = currentDate.substring(0, 7);
            if(currentMonthYear.equals(monthYear)) {
                SimpleDateFormat ft2 = new SimpleDateFormat("dd-MM-yyyy");

                String bookReleaseDate2 = ft2.format(release.getReleaseDate());

                JLabel titleAuthor = new JLabel(release.getTitle()+"   by   "+release.getAuthor());
                JLabel releaseDate = new JLabel("Releases "+bookReleaseDate2 + " :");

                ImageIcon image = new ImageIcon("D:\\Facultate\\Anul_2\\OOP\\BetterReads\\reviews_page.png");
                Image scaledImage = image.getImage().getScaledInstance(100, 140, Image.SCALE_SMOOTH);
                JLabel labelImage = new JLabel(new ImageIcon(scaledImage));

                JPanel smallPanel = GridBagLayout.createReleasesPanel(releaseDate,labelImage, titleAuthor);
                smallPanel.setBackground(new Color(255, 227, 198));
                releasesPanel.add(smallPanel);

                releasesPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            }
        }

        JScrollPane scrollPaneReleases = new JScrollPane(releasesPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        tabbedPane.addTab("Releases", scrollPaneReleases);
        frame.getContentPane().add(tabbedPane);

        AccountView accountView = new AccountView();
        AccountController accountController = new AccountController(account, accountView);
        tabbedPane.addTab("Account", accountView);
        frame.getContentPane().add(tabbedPane);

        FriendsView friendsView = new FriendsView();
        FriendsController friendsController = new FriendsController(account, friendsView);
        tabbedPane.addTab("Friends",friendsView);
        frame.getContentPane().add(tabbedPane);

        frame.setVisible(true);
    }

}
