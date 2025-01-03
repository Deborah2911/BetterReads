package Models;

import Database.Book;
import Database.Category;
import Database.DBConnection;
import Database.User;

import java.util.List;

public class SearchModel{

    private final User user;

    public SearchModel(User user) {
        this.user=user;
    }

    public List<Book> getBooksList() {
        return DBConnection.getBook();
    }
    public List<Category> getCategoriesList(){return DBConnection.getCategory();}
    public User getUser(){ return this.user;}
}
