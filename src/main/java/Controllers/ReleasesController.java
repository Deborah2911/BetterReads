package Controllers;

import Models.ReleasesModel;
import Views.ReleasesView;
import java.util.List;
import Database.Book;

public class ReleasesController {
    private ReleasesModel model;
    private ReleasesView view;

    public ReleasesController(ReleasesModel model, ReleasesView view) {
        this.model = model;
        this.view = view;
        loadReleases();
    }

    private void loadReleases() {
        List<Book> releases = model.getReleases();
        view.updateReleases(releases);
    }
}
