package Models;

import Database.Book;
import Database.DBConnection;

import java.util.List;

public class SearchModel {
    public List<Book> getBooksList() {
        return DBConnection.getBook();
    }
}
