package iPublisher;

import javafx.beans.property.BooleanProperty;

public class Publisher extends PublisherUnit{
    //Attribute to be manipulated
    private final BooleanProperty reportAccess;

    //constructor method for Publisher model class
    public Publisher(String name, String id, String branch, BooleanProperty reportAccess) {
        super(name, id, branch);
        this.reportAccess = reportAccess;
    }
    /*
        Setter and Getter Methods for model class
     */
    public void setReportAccess(Boolean accessStatus ){
        reportAccess.set(accessStatus);
    }
    public BooleanProperty reportAccessProperty() {
        return reportAccess;
    }
    public Boolean getReportDueDate() {
        return reportAccess.get();
    }

}
