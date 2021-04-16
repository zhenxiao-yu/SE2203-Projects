package iPublisher;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class TopManager extends Manager{

    //Attribute to be manipulated
    private final StringProperty reviewDueDate;

    //constructor method for TopManager model class
    public TopManager(String name, String id, String branch, IntegerProperty noOfPages, StringProperty reportDueDate, StringProperty reviewDueDate) {
        super(name, id, branch, noOfPages, reportDueDate);
        this.reviewDueDate = reviewDueDate;
    }
    public void setReviewDueDate(String date){
        reviewDueDate.set(date);
    }

    public String getReviewDueDate() {
        return reviewDueDate.get();
    }

    public StringProperty reviewDueDateProperty() {
        return reviewDueDate;
    }
}
