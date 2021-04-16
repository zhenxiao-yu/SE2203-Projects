package iPublisher;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class Manager extends PublisherUnit{
    //Attribute to be manipulated
    private final StringProperty reportDueDate;
    //constructor method for Manager model class
    public Manager(String name, String id, String branch, IntegerProperty noOfPages, StringProperty reportDueDate) {
        super(name, id, branch);
        this.reportDueDate = reportDueDate;
    }
     /*
        Setter and Getter Methods for model class
     */
    public void setReportDueDate(String date ){
        reportDueDate.set(date);
    }
    public StringProperty dueDateProperty() {
        return reportDueDate;
    }
    public String getReportDueDate() {
        return reportDueDate.get();
    }
}
