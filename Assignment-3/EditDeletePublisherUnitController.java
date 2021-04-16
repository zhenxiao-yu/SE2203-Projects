package iPublisher;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EditDeletePublisherUnitController implements Initializable {

    @FXML
    Button cancelButton; //reference to cancel button

    @FXML
    Button deleteButton;  //reference to delete button

    @FXML
    Button confirmButton;  //reference to confirm update button

    @FXML
    TextField newName;  //reference to new name text field

    @FXML
    TextField newID; //reference to new Id text field

    @FXML
    TextField newBranch; //reference to new branch name text field

    @FXML
    ComboBox<String> oldName; //reference to ComboBox that contains existing employee names

    private PublisherUnitAdapter publisherUnitsAdapter; //reference to the adapter class

    //construct adapter model
    public void setModel(PublisherUnitAdapter publisherUnits) {
        publisherUnitsAdapter = publisherUnits;
        buildComboBoxData();
    }

    //close the window
    public void exitWindow() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    //update the data base table with new information the user entered
    public void confirmChanges() throws SQLException {
        publisherUnitsAdapter.editPublisherUnit(oldName.getValue().trim(),newName.getText().trim(), newID.getText().trim(), newBranch.getText().trim());
    }

    //delete the entire row of items from the database table
    public void deleteItem() throws SQLException {
        publisherUnitsAdapter.deletePublisherUnit(oldName.getValue().trim());
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        stage.close();
    }

    //create list to fill combobox with name of employees
    final ObservableList<String> data = FXCollections.observableArrayList();
    // fill list for combo box
    public void buildComboBoxData() {
        try {
            data.addAll(publisherUnitsAdapter.getEmployeeList());
        } catch (SQLException ex) { }
    }

    // fill combobox with list of employee names
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        oldName.setItems(data);
    }
}


