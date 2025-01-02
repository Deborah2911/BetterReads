package Controllers;

import Models.ReviewsModel;
import Views.ReviewsView;
import java.util.List;
import Database.Reviews;

public class ReviewsController {
    private ReviewsModel model;
    private ReviewsView view;

    public ReviewsController(ReviewsModel model, ReviewsView view) {
        this.model = model;
        this.view = view;
        loadReviews();
    }

    private void loadReviews() {
        List<Reviews> reviews = model.getReviews();
        view.updateReviews(reviews);
    }
}
