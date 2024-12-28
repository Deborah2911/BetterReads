package Views;

import Database.Book;
import Database.DBConnection;
import Database.Reviews;
import Database.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
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

            JPanel smallPanel = GridBagLayoutReviews.createPanel(userFullName, labelImage, titleAuthor, rating);
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

                JPanel smallPanel = GridBagLayoutReviews.createReleasesPanel(releaseDate,labelImage, titleAuthor);
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

        // Account panel
        JPanel accountPanel = new JPanel();
        accountPanel.setLayout(new BoxLayout(accountPanel, BoxLayout.Y_AXIS));
        accountPanel.setBackground(Color.WHITE);

        JLabel fullNameLabel = new JLabel("Full name: " + account.getName());
        JLabel usernameLabel = new JLabel("Username: " + account.getUsername());
        JLabel passwordLabel = new JLabel("Password: ");

        JPasswordField passwordField = new JPasswordField(account.getPassword());
        passwordField.setEchoChar('•'); // Hide characters with a bullet
        passwordField.setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
        passwordField.setForeground(new Color(75, 37, 100));
        passwordField.setEditable(false); // Make it non-editable

        JButton togglePasswordButton = new JButton("Show");
        togglePasswordButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        togglePasswordButton.addActionListener(e -> {
            if (passwordField.getEchoChar() == '•') {
                passwordField.setEchoChar((char) 0); // Show password
                togglePasswordButton.setText("Hide");
            } else {
                passwordField.setEchoChar('•'); // Hide password
                togglePasswordButton.setText("Show");
            }
        });

        JButton modifyUsernameButton = new JButton("Modify Username");
        modifyUsernameButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        modifyUsernameButton.addActionListener(e -> {
            JTextField usernameField = new JTextField(account.getUsername(), 20);
            int result = JOptionPane.showConfirmDialog(null, usernameField,
                    "Modify Username", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                if(DBConnection.modifyUsername(account.getUsername(), usernameField.getText())) {
                    account.setUsername(usernameField.getText());
                    usernameLabel.setText("Username: " + account.getUsername());
                }
                else {
                    JOptionPane.showMessageDialog(null, "Error while modifying username. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        JButton modifyFullNameButton = new JButton("Modify Full Name");
        modifyFullNameButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        modifyFullNameButton.addActionListener(e -> {
            JTextField fullNameField = new JTextField(account.getName(), 20);
            int result = JOptionPane.showConfirmDialog(null, fullNameField,
                    "Modify Full Name", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                if(DBConnection.modifyName(account.getName(), fullNameField.getText())) {
                    account.setName(fullNameField.getText());
                    fullNameLabel.setText("Full name: " + account.getName());
                }
                else {
                    JOptionPane.showMessageDialog(null, "Error while modifying name. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JPanel passwordPanel = new JPanel(new BorderLayout());
        passwordPanel.setBackground(new Color(235, 213, 243));
        passwordPanel.add(passwordLabel, BorderLayout.WEST);
        passwordPanel.add(passwordField, BorderLayout.CENTER);
        passwordPanel.add(togglePasswordButton, BorderLayout.EAST);

        JPanel usernamePanel = new JPanel(new BorderLayout());
        usernamePanel.setBackground(new Color(235, 213, 243));
        usernamePanel.add(usernameLabel, BorderLayout.CENTER);
        usernamePanel.add(modifyUsernameButton, BorderLayout.EAST);

        JPanel fullNamePanel = new JPanel(new BorderLayout());
        fullNamePanel.setBackground(new Color(235, 213, 243));
        fullNamePanel.add(fullNameLabel, BorderLayout.CENTER);
        fullNamePanel.add(modifyFullNameButton, BorderLayout.EAST);

        JPanel smallPanel = new JPanel();
        smallPanel.setLayout(new BoxLayout(smallPanel, BoxLayout.Y_AXIS));
        smallPanel.setBackground(new Color(235, 213, 243));
        smallPanel.add(usernamePanel);
        smallPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        smallPanel.add(passwordPanel);
        smallPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        smallPanel.add(fullNamePanel);

        accountPanel.add(smallPanel);
        accountPanel.add(Box.createRigidArea(new Dimension(0, 5)));

//        JScrollPane scrollPaneAccount = new JScrollPane(accountPanel);
//        scrollPaneAccount.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//        scrollPaneAccount.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//        scrollPaneAccount.getVerticalScrollBar().setUnitIncrement(16);

        tabbedPane.addTab("Account", accountPanel);
        frame.getContentPane().add(tabbedPane);

        frame.setVisible(true);
    }

}
