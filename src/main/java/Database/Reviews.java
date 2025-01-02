package Database;

import java.sql.Date;

public class Reviews {
    private double rating;
    private String title;
    private String author;
    private String userFullName;

    public Reviews(double rating, String title, String author, String userFullName) {
        this.title = title;
        this.author = author;
        this.userFullName = userFullName;
        this.rating=rating;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public double getRating(){ return rating; }

    @Override
    public String toString() {
        return "Review{" +
                ", user='" + userFullName + '\'' +
                ", title='" + title + '\n' +
                ", author=" + author + '\n' +
                ", rating=" + rating + '\n' +
                '}';
    }
}
