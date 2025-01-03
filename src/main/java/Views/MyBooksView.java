package Views;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
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

    public MyBooksView() {
        setLayout(new BorderLayout());
        setBackground(new Color(245, 245, 245)); // Light background for the entire view

        // Create buttons at the top (centered) with pastel colors
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(255, 227, 198)); // Soft pastel background

        currentlyReadingButton = createStyledButton("Currently Reading", new Color(198, 235, 255));
        currentlyReadingButton.setForeground(Color.BLACK);
        readButton = createStyledButton("Read", new Color(220, 198, 255));
        wantToReadButton = createStyledButton("Want to Read", new Color(255, 198, 220));

        buttonPanel.add(currentlyReadingButton);
        buttonPanel.add(readButton);
        buttonPanel.add(wantToReadButton);

        // Create CardLayout and Panels for the categories
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setBackground(new Color(255, 245, 230)); // Soft pastel background for the card panel

        currentlyReadingPanel = createStyledPanel();
        readPanel = createStyledPanel();
        wantToReadPanel = createStyledPanel();

        cardPanel.add(currentlyReadingPanel, "Currently Reading");
        cardPanel.add(readPanel, "Read");
        cardPanel.add(wantToReadPanel, "Want to Read");

        add(buttonPanel, BorderLayout.NORTH); // Add buttons panel to the top
        add(cardPanel, BorderLayout.CENTER);  // Add card panel in the center
    }

    public void setForegroundCRButton(Color color){
        currentlyReadingButton.setForeground(color);
    }

    public void setForegroundReadButton(Color color){
        readButton.setForeground(color);
    }

    public void setForegroundWTRButton(Color color){
        wantToReadButton.setForeground(color);
    }

    private JButton createStyledButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setOpaque(true);

        // Optional hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(bgColor.darker());
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(bgColor);
            }
        });

        return button;
    }

    private JPanel createStyledPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panel.setBackground(new Color(255, 245, 230)); // Soft pastel background
        return panel;
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

    public void displayBooks(String category, List<Book> books) {
        JPanel panel = getPanelByCategory(category);
        panel.removeAll();

        for (Book book : books) {
            ImageIcon image = new ImageIcon("C:\\Users\\Denisa\\Downloads\\No_Cover.jpg");
            Image scaledImage = image.getImage().getScaledInstance(100, 140, Image.SCALE_SMOOTH);
            JLabel bookCover = new JLabel(new ImageIcon(scaledImage));
            JLabel title = new JLabel(book.getTitle());
            JLabel author = new JLabel("by " + book.getAuthor());

            title.setFont(new Font("Arial", Font.BOLD, 14));
            author.setFont(new Font("Arial", Font.PLAIN, 12));

            JPanel bookPanel = createBookPanel(bookCover, title, author);
            bookPanel.setBackground(new Color(255, 227, 198)); // Soft pastel for book panels

            panel.add(bookPanel);
        }

        panel.revalidate();
        panel.repaint();
    }

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
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridheight = 1;
        panel.add(title, gbc);

        // Author
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridheight = 1;
        panel.add(author, gbc);

        panel.setPreferredSize(new Dimension(500, 150));
        panel.setBorder(BorderFactory.createLineBorder(new Color(255, 198, 198), 1, true)); // Border with soft color
        return panel;
    }

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

    public JPanel getCardPanel() {
        return cardPanel;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }
}
