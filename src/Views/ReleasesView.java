package Views;

import Database.Book;
import Database.DBConnection;
import Database.Reviews;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReleasesView extends JFrame {

    //private final JButton accountButton;

    public ReleasesView(){

        final JFrame frame = new JFrame("Reviews");

        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.WHITE);
//select rating, title, author, name from reviews join books on reviews.book_id = books.id join users on reviews.user_id = users.id
        List<Reviews> reviewsList = new ArrayList<>();
        reviewsList = DBConnection.getReviews();

        for(Reviews review: reviewsList){

            JLabel titleAuthor = new JLabel(review.getTitle()+"   by  "+review.getAuthor());
            JLabel userFullName = new JLabel(review.getUserFullName()+" reviewed ");
            JLabel rating = new JLabel(review.getRating()+"/5 stars ");

            ImageIcon image = new ImageIcon("D:\\Facultate\\Anul_2\\OOP\\BetterReads\\reviews_page.png");
            Image scaledImage = image.getImage().getScaledInstance(100, 140, Image.SCALE_SMOOTH);
            JLabel labelImage = new JLabel(new ImageIcon(scaledImage));

            JPanel smallPanel = GridBagLayoutReviews.createPanel(userFullName, labelImage, titleAuthor, rating);
            smallPanel.setBackground(new Color(235, 213, 243));
            mainPanel.add(smallPanel);

            mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        }

        //accountButton=new JButton("My Account");

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        //add(accountButton);
        tabbedPane.addTab("Reviews", scrollPane);



        JPanel mainPanelReleases = new JPanel();
        mainPanelReleases.setLayout(new BoxLayout(mainPanelReleases, BoxLayout.Y_AXIS));
        mainPanelReleases.setBackground(Color.WHITE);
        List<Book> releasesList = new ArrayList<>();
        releasesList = DBConnection.getBook();

        for(Book release: releasesList){

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

                JPanel smallPanel = GridBagLayoutReviews.createReleasesPanel(releaseDate,labelImage, titleAuthor);
                smallPanel.setBackground(new Color(255, 227, 198));
                mainPanelReleases.add(smallPanel);

                mainPanelReleases.add(Box.createRigidArea(new Dimension(0, 5)));
            }

            }

        //accountButton=new JButton("My Account");

        JScrollPane scrollPaneReleases = new JScrollPane(mainPanelReleases);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        tabbedPane.addTab("Releases", scrollPaneReleases);

        frame.getContentPane().add(tabbedPane);
        frame.setVisible(true);

    }

//    public void setAccountButtonActionListener(ActionListener actionListener){
//        accountButton.addActionListener(actionListener);
//    }

}
