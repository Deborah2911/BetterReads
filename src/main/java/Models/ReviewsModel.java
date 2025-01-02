package Models;

import Database.DBConnection;
import Database.Reviews;
import java.util.List;

public class ReviewsModel {
    private final int userId;

    public ReviewsModel(int userId) {
        this.userId = userId;
    }

    public List<Reviews> getReviews() {
        return DBConnection.getReviews(userId);
    }
}
