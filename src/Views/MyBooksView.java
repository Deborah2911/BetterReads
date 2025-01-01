package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import Database.Book;

public class MyBooksView extends JPanel {
    private final CardLayout cardLayout;
    private final JPanel cardPanel;

    private final JPanel currentlyReadingPanel;
    private final JPanel readPanel;
    private final JPanel wantToReadPanel;

    private final JButton currentlyReadingButton;
    private final JButton readButton;
    private final JButton wantToReadButton;

    // Constructor
    public MyBooksView() {
        setLayout(new BorderLayout());

        // Create buttons at the top (centered)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        currentlyReadingButton = new JButton("Currently Reading");
        readButton = new JButton("Read");
        wantToReadButton = new JButton("Want to Read");

        buttonPanel.add(currentlyReadingButton);
        buttonPanel.add(readButton);
        buttonPanel.add(wantToReadButton);

        // Create CardLayout and Panels for the categories
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        currentlyReadingPanel = new JPanel(new FlowLayout());
        readPanel = new JPanel(new FlowLayout());
        wantToReadPanel = new JPanel(new FlowLayout());

        cardPanel.add(currentlyReadingPanel, "Currently Reading");
        cardPanel.add(readPanel, "Read");
        cardPanel.add(wantToReadPanel, "Want to Read");

        add(buttonPanel, BorderLayout.NORTH); // Add buttons panel to the top
        add(cardPanel, BorderLayout.CENTER);  // Add card panel in the center
    }

    public void setCurrentlyReadingButton(ActionListener actionListener) {
        currentlyReadingButton.addActionListener(actionListener);
    }

    public void setReadButton(ActionListener actionListener) {
        readButton.addActionListener(actionListener);
    }

    public void setWantToReadButton(ActionListener actionListener) {
        wantToReadButton.addActionListener(actionListener);
    }

    // Update the panels with books
    public void displayBooks(String category, List<Book> books) {
        JPanel panel = getPanelByCategory(category);
        panel.removeAll();

        for (Book book : books) {
            ImageIcon image = new ImageIcon("C:\\Users\\Denisa\\Downloads\\No_Cover.jpg");
            Image scaledImage = image.getImage().getScaledInstance(100, 140, Image.SCALE_SMOOTH);
            JLabel bookCover = new JLabel(new ImageIcon(scaledImage)); // Assuming Book has a cover path
            JLabel title = new JLabel(book.getTitle());
            JLabel author = new JLabel("by " + book.getAuthor());

            panel.add(createBookPanel(bookCover, title, author));
        }

        panel.revalidate();
        panel.repaint();
    }

    // Create a panel for displaying each book
    public static JPanel createBookPanel(JLabel bookCover, JLabel title, JLabel author) {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Book Cover
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.weighty = 1.0;
        gbc.weightx = 1.0;
        gbc.ipady = 0;
        gbc.ipadx = 10;
        gbc.gridheight = 2;
        panel.add(bookCover, gbc);

        // Title
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridheight = 1;
        panel.add(title, gbc);

        // Author
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridheight = 1;
        panel.add(author, gbc);

        panel.setPreferredSize(new Dimension(500, 150));
        return panel;
    }

    // Get the panel corresponding to the selected category
    private JPanel getPanelByCategory(String category) {
        switch (category) {
            case "Currently Reading":
                return currentlyReadingPanel;
            case "Read":
                return readPanel;
            case "Want to Read":
                return wantToReadPanel;
            default:
                return currentlyReadingPanel;
        }
    }

    // Getters
    public JPanel getCardPanel() {
        return cardPanel;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }
}
