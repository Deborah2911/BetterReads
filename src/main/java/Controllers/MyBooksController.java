package Controllers;

import Database.User;
import Models.MyBooksModel;
import Views.MyBooksView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyBooksController {
    private final User user;
    private final MyBooksModel model;
    private final MyBooksView view;

    public MyBooksController(User account, MyBooksView view) {
        this.user = account;
        this.view = view;
        model = new MyBooksModel(account);

        model.loadCategorizedBooks();

//        view.displayBooks("Currently Reading", model.getCurrentlyReadingBooks());
//        view.displayBooks("Read", model.getReadBooks());
//        view.displayBooks("Want to Read", model.getWantToReadBooks());

        view.setCurrentlyReadingButton(new CurrentlyReadingActionListener());
        view.setReadButton(new ReadActionListener());
        view.setWantToReadButton(new WantToReadActionListener());
        view.setVisible(true);
    }

    private class CurrentlyReadingActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            model.loadCategorizedBooks();
            view.displayBooks("Currently Reading", model.getCurrentlyReadingBooks());
            view.setForegroundCRButton(Color.DARK_GRAY);
            view.setForegroundWTRButton(Color.WHITE);
            view.setForegroundReadButton(Color.WHITE);
            view.getCardLayout().show(view.getCardPanel(), "Currently Reading");
        }
    }

    private class ReadActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            model.loadCategorizedBooks();
            view.displayBooks("Read", model.getReadBooks());
            view.setForegroundReadButton(Color.DARK_GRAY);
            view.setForegroundWTRButton(Color.WHITE);
            view.setForegroundCRButton(Color.WHITE);
            view.getCardLayout().show(view.getCardPanel(), "Read");
        }
    }

    private class WantToReadActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            model.loadCategorizedBooks();
            view.displayBooks("Want to Read", model.getWantToReadBooks());
            view.setForegroundWTRButton(Color.DARK_GRAY);
            view.setForegroundCRButton(Color.WHITE);
            view.setForegroundReadButton(Color.WHITE);
            view.getCardLayout().show(view.getCardPanel(), "Want to Read");
        }
    }
}
