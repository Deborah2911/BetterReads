package Database;
import java.sql.Date;

public class Book {
    private int id;
    private String title;
    private String author;
    private Date releaseDate;
    private String genre;
    private int category;
    private byte[] imgBytes;

    public Book(int id, String title, String author, Date releaseDate, String genre, byte[] imgBytes) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.genre = genre;
        if(imgBytes!=null)
            this.imgBytes = imgBytes;
        else
            this.imgBytes = "D:\\Facultate\\Anul_2\\DB\\MiniBetterReads\\reviews_page.png".getBytes();
    }

    public byte[] getImgBytes() {
        return imgBytes;
    }

    public void setImgBytes(byte[] imgBytes) {
        this.imgBytes = imgBytes;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public int getId() { return id; }

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