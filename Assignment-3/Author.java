package iPublisher;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Author {
    //Attribute to be manipulated
    private final StringProperty authorName;
    //constructor method for Title model class
    public Author(String name) {
        this.authorName = new SimpleStringProperty(name);
    }

    /*
       Setter and Getter Methods for model class
    */
    public void setAuthorName(String name) {
        authorName.set(name);
    }
    public StringProperty authorNameProperty() {
        return authorName;
    }
    public String getAuthorName() {
        return authorName.get();
    }
}

