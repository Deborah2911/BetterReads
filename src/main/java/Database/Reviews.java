package Database;

import java.sql.Date;

public class Reviews {
    private double rating;
    private String title;
    private String author;
    private String userFullName;
    private byte[] imgBytes;

    public Reviews(double rating, String title, String author, String userFullName, byte[] imgBytes) {
        this.title = title;
        this.author = author;
        this.userFullName = userFullName;
        this.rating=rating;
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
