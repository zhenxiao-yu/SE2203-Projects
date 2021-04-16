package iPublisher;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PublisherUnit {
    //Attribute to be manipulated
    private final StringProperty employeeName;
    private final StringProperty employeeId;
    private final StringProperty branchName;

    //constructor method for Title model class
    public PublisherUnit(String name, String id, String branch) {
        this.employeeName = new SimpleStringProperty(name);
        this.employeeId = new SimpleStringProperty(id);
        this.branchName = new SimpleStringProperty(branch);
    }

    /*
       Setter and Getter Methods for model class
    */
    public void setEmployeeName(String name) {
        employeeName.set(name);
    }
    public StringProperty employeeNameProperty() {
        return employeeName;
    }
    public String getEmployeeName() {
        return employeeName.get();
    }

    public void setEmployeeId(String ID) {
        employeeId.set(ID);
    }
    public StringProperty employeeIDProperty() {
        return employeeId;
    }
    public String getEmployeeId() {
        return employeeId.get();
    }

    public void setBranchName(String branch) {
        branchName.set(branch);
    }
    public StringProperty branchNameProperty() {
        return branchName;
    }
    public String getBranchName() {
        return branchName.get();
    }

}
