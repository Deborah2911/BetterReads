package Models;

import Database.Book;
import Database.DBConnection;
import Database.User;

import java.util.List;
import java.util.ArrayList;

public class MyBooksModel {

    private final List<Book> currentlyReadingBooks = new ArrayList<>();
    private final List<Book> readBooks = new ArrayList<>();
    private final List<Book> wantToReadBooks = new ArrayList<>();
    private final User user;

    public MyBooksModel(User user) {
        this.user = user;
    }

    // Method to fetch and categorize books
    public void loadCategorizedBooks() {

        currentlyReadingBooks.clear();
        readBooks.clear();
        wantToReadBooks.clear();

        // Fetch categorized books from DB
        List<Book> books = DBConnection.getCategorizedBooks(user.getId());

        // Process the result and categorize books
        for (Book book : books) {
            switch (book.getCategory()) {
                case 1:
                    currentlyReadingBooks.add(book);
                    break;
                case 2:
                    wantToReadBooks.add(book);
                    break;
                case 3:
                    readBooks.add(book);
                    break;
            }
        }
    }

    public List<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public List<Book> getReadBooks() {
        return readBooks;
    }

    public List<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }
}
