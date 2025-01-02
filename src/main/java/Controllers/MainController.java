package Controllers;

import Database.User;
import Models.*;
import Views.*;

import javax.swing.*;

public class MainController {
    private MainView view;

    public MainController(User account, MainView view) {
        this.view = view;
        view.setVisible(true);

        // Initialize Reviews
        ReviewsView reviewsView = new ReviewsView();
        ReviewsModel reviewsModel = new ReviewsModel(account.getId());
        ReviewsController reviewsController = new ReviewsController(reviewsModel, reviewsView);
        view.addTab("Reviews", new JScrollPane(reviewsView));

        // Initialize Releases
        ReleasesView releasesView = new ReleasesView();
        ReleasesModel releasesModel = new ReleasesModel();
        ReleasesController releasesController = new ReleasesController(releasesModel, releasesView);
        view.addTab("Releases", new JScrollPane(releasesView));

        // Initialize Account
        AccountView accountView = new AccountView();
        AccountController accountController = new AccountController(account, accountView);
        view.addTab("Account", accountView);

        // Initialize MyBooks
        MyBooksView myBooksView = new MyBooksView();
        MyBooksController myBooksController = new MyBooksController(account, myBooksView);
        view.addTab("My Books", myBooksView);

        // Initialize Friends
        FriendsView friendsView = new FriendsView();
        FriendsController friendsController = new FriendsController(account, friendsView);
        view.addTab("Friends", friendsView);

        // Initialize Search
        SearchView searchView = new SearchView();
        SearchModel searchModel = new SearchModel();
        SearchController searchController = new SearchController(searchModel, searchView);
        view.addTab("Search", searchView);
    }
}
