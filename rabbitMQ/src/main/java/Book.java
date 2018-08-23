import java.io.Serializable;
import java.util.Date;

/** @Author: shuyizhi @Date: 2018-08-21 15:12 @Description: */
public class Book implements Serializable {
    private static final long serialVersionUID = 6226329292121192448L;
    private int id;
    private String name;
    private String author;
    private double price;
    private Date publishDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "Book{"
                + "id="
                + id
                + ", name='"
                + name
                + '\''
                + ", author='"
                + author
                + '\''
                + ", price="
                + price
                + ", publishDate="
                + publishDate
                + '}';
    }
}
