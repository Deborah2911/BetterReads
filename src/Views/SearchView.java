package Views;

import Database.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class SearchView extends JPanel {
    private final JTextField searchField;
    private final JButton searchButton;
    private final JPanel resultsPanel;

    public SearchView() {
        // Set layout and background
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Top search bar panel
        JPanel searchBarPanel = new JPanel(new BorderLayout());
        searchBarPanel.setBackground(new Color(220, 220, 220));
        searchBarPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        searchField = new JTextField();
        searchField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        searchField.setPreferredSize(new Dimension(200, 30));
        searchBarPanel.add(searchField, BorderLayout.CENTER);

        searchButton = new JButton("Search");
        searchButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        searchButton.setBackground(new Color(200, 230, 255));
        searchBarPanel.add(searchButton, BorderLayout.EAST);

        add(searchBarPanel, BorderLayout.NORTH);

        // Results panel for displaying books
        resultsPanel = new JPanel();
        resultsPanel.setLayout(new BoxLayout(resultsPanel, BoxLayout.Y_AXIS));
        resultsPanel.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(resultsPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        add(scrollPane, BorderLayout.CENTER);
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public String getSearchQuery() {
        return searchField.getText();
    }

    public void setSearchActionListener(ActionListener actionListener) {
        searchButton.addActionListener(actionListener);
    }

    public void displayResults(List<Book> books) {
        resultsPanel.removeAll();

        if (books.isEmpty()) {
            JLabel noResultsLabel = new JLabel("No results found.");
            noResultsLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
            noResultsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            resultsPanel.add(noResultsLabel);
        } else {
            for (Book book : books) {
                JPanel bookPanel = createBookPanel(book);
                resultsPanel.add(bookPanel);
                resultsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            }
        }

        resultsPanel.revalidate();
        resultsPanel.repaint();
    }

    private JPanel createBookPanel(Book book) {
        JLabel titleLabel = new JLabel("Title: " + book.getTitle());
        JLabel authorLabel = new JLabel("Author: " + book.getAuthor());

        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.setBackground(new Color(240, 240, 255));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(titleLabel);
        panel.add(authorLabel);

        return panel;
    }
}
