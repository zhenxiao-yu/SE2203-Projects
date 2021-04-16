package iPublisher;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Title {
    //Attribute to be manipulated
    private final IntegerProperty noOfPages;
    private final StringProperty title;
    private final StringProperty date;

    //constructor method for Title model class
    public Title(String title, String pubDate, int bookLength) {
        this.title = new SimpleStringProperty(title);
        this.date = new SimpleStringProperty(pubDate);
        this.noOfPages = new SimpleIntegerProperty(bookLength);
    }
    /*
        Setter and Getter Methods for model class
     */
    public void setTitle(String titleName) {
        title.set(titleName);
    }
    public StringProperty titleProperty() {
        return title;
    }
    public String getTitle() {
        return title.get();
    }

    public void setDate(String pubDate) {
        date.set(pubDate);
    }
    public StringProperty dateProperty() {
        return title;
    }
    public String getDate() {
        return date.get();
    }

    public void setNoOfPages(int bookLength) {
        noOfPages.set(bookLength);
    }
    public IntegerProperty noOfPagesProperty() {
        return noOfPages;
    }
    public Integer setNoOfPages() {
        return noOfPages.get();
    }

}
