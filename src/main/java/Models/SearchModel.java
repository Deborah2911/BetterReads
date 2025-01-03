package Models;

import Database.Book;
import Database.Category;
import Database.DBConnection;
import Database.User;

import java.util.List;

public class SearchModel extends MyBooksModel{

    public SearchModel(User user) {
        super(user);
    }

    public List<Book> getBooksList() {
        return DBConnection.getBook();
    }
    public List<Category> getCategoriesList(){return DBConnection.getCategory();}
}
