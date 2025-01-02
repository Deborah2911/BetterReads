package Controllers;

import Database.Book;
import Models.SearchModel;
import Views.SearchView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SearchController {
    private final SearchModel model;
    private final SearchView view;

    public SearchController(SearchModel model, SearchView view) {
        this.model = model;
        this.view = view;

        view.setSearchActionListener(new SearchActionListener());
    }

    private class SearchActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            List<Book> totalBooks = model.getBooksList();
            List<Book> foundBooks = new ArrayList<>();
            String searchQuery = view.getSearchQuery();

            for (Book book : totalBooks) {
                if(book.getTitle().toLowerCase().contains(searchQuery.toLowerCase())) {
                    foundBooks.add(book);
                }
            }
            view.displayResults(foundBooks);
        }
    }
}
