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

public class EditDeleteTitleController implements Initializable {

    @FXML
    Button cancelButton; //reference to cancel button

    @FXML
    Button deleteButton;  //reference to delete button

    @FXML
    Button confirmButton; //reference to confirm update button

    @FXML
    TextField newTitle; //reference to newTitle text field

    @FXML
    TextField newPublicationDate; //reference to publication date text field

    @FXML
    TextField newPageNum; //reference to page number text field

    @FXML
    ComboBox<String> oldTitle; //reference to ComboBox that contains existing old titles

    private TitleAdapter titlesAdapter; //reference to the adapter class

    //construct adapter model
    public void setModel(TitleAdapter titles) {
        titlesAdapter = titles;
        buildComboBoxData();
    }

    //close the window
    public void exitWindow() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    //update the data base table with new information the user entered
    public void confirmChanges() throws SQLException {
        titlesAdapter.editTitle(oldTitle.getValue().trim(),
                newTitle.getText().trim(),
                newPublicationDate.getText().trim(),
                Integer.parseInt(newPageNum.getText().trim()));
        Stage stage = (Stage) confirmButton.getScene().getWindow();
        stage.close();
    }

    //delete the entire row of items from the database table
    public void deleteItem() throws SQLException {
        titlesAdapter.deleteTitle(oldTitle.getValue().trim());
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        stage.close();
    }

    //create list to fill combobox with titles
    final ObservableList<String> data = FXCollections.observableArrayList();
    // fill list for combo box
    public void buildComboBoxData() {
        try {
            data.addAll(titlesAdapter.getTitlesList());
        } catch (SQLException ex) { }
    }

    // fill combobox with list of existing titles
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        oldTitle.setItems(data);
    }

}
