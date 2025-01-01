package Models;

import Database.Book;
import Database.DBConnection;
import java.util.List;

public class ReleasesModel {
    public List<Book> getReleases() {
        return DBConnection.getBooksReleasedThisMonth();
    }
}
