package Database;
import java.sql.Date;

public class Book {
    private int id;
    private String title;
    private String author;
    private Date releaseDate;
    private String genre;

    public Book(int id, String title, String author, Date releaseDate, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\n' +
                ", author=" + author + '\n' +
                ", releaseDate=" + releaseDate + '\n' +
                ", genre='" + genre + '\'' +
                '}';
    }
}