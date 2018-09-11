package zhu_tianwei;

import java.io.Serializable;
import java.util.Date;

/** @Author: shuyizhi @Date: 2018-08-24 14:49 @Description: */
public class BookModel implements Serializable {
    private static final long serialVersionUID = -941472547830325544L;
    private int id;
    private String bookName;
    private String authorName;
    private Date publishDate;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookModel{"
                + "id="
                + id
                + ", bookName='"
                + bookName
                + '\''
                + ", authorName='"
                + authorName
                + '\''
                + ", publishDate="
                + publishDate
                + ", price="
                + price
                + '}';
    }
}
