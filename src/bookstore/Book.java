package bookstore;
import javafx.scene.control.CheckBox;

public class Book {

    private final String title;
    private final double price;
    public CheckBox select;

    public Book(String bookTitle, double bookPrice) {
        this.title = bookTitle;
        this.price = bookPrice;
        select = new CheckBox();
    }

    public String getTitle() {
        return this.title;
    }

    public double getPrice() {
        return this.price;
    }

    public CheckBox getSelect() {
        return select;
    }

    public void setSelect(CheckBox select) {
        this.select = select;
    }//used to unselect checkbox when you leave customer home screen

}