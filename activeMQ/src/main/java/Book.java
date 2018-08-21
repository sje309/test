import java.io.Serializable;

/** @Author: shuyizhi @Date: 2018-08-20 10:53 @Description: */
public class Book implements Serializable {
    private static final long serialVersionUID = -6212470156629515269L;
    private int id;
    private String name;
    private String author;
    private double price;

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
                + '}';
    }
}
