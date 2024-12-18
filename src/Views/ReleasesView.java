package Views;

import Database.Book;
import Database.DBConnection;
import Database.Reviews;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ReleasesView extends JFrame {

    private final JButton accountButton;

    public ReleasesView(){

        final JFrame frame = new JFrame("Reviews");

        frame.setSize(600, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.WHITE);
//select rating, title, author, name from reviews join books on reviews.book_id = books.id join users on reviews.user_id = users.id
        List<Reviews> reviewsList = new ArrayList<>();
        reviewsList = DBConnection.getReviews();

        for(Reviews review: reviewsList){

            JLabel titleAuthor = new JLabel(review.getTitle()+" by "+review.getAuthor());
            JLabel userFullName = new JLabel(review.getUserFullName()+" reviewed ");
            JLabel rating = new JLabel(review.getRating()+"/5 stars ");

            ImageIcon image = new ImageIcon("D:\\Facultate\\Anul_2\\OOP\\BetterReads\\reviews_page.png");
            Image scaledImage = image.getImage().getScaledInstance(100, 140, Image.SCALE_SMOOTH);
            JLabel labelImage = new JLabel(new ImageIcon(scaledImage));

            JPanel smallPanel = GridBagLayoutReviews.createPanel(userFullName, labelImage, titleAuthor, rating);
            smallPanel.setBackground(Color.PINK);
            mainPanel.add(smallPanel);

            mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        }

//        for (int i = 0; i < 10; i++) {
//            JLabel user1 = new JLabel("user" + i + " reviewed");
//            JLabel titleAuthor = new JLabel("Title by Author");
//            JLabel review = new JLabel("3.5/5 stars");
//
//            ImageIcon image = new ImageIcon("D:\\Facultate\\Anul_2\\OOP\\BetterReads\\reviews_page.png");
//            Image scaledImage = image.getImage().getScaledInstance(100, 140, Image.SCALE_SMOOTH);
//            JLabel labelImage = new JLabel(new ImageIcon(scaledImage));
//
//            JPanel smallPanel = GridBagLayoutReviews.createPanel(user1, labelImage, titleAuthor, review);
//            smallPanel.setBackground(Color.PINK);
//            mainPanel.add(smallPanel);
//
//            mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
//        }
        accountButton=new JButton("My Account");

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        add(accountButton);

        frame.getContentPane().add(scrollPane);
        frame.setVisible(true);

    }

    public void setAccountButtonActionListener(ActionListener actionListener){
        accountButton.addActionListener(actionListener);
    }
}
