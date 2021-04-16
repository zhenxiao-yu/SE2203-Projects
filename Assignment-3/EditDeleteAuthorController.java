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

public class EditDeleteAuthorController implements Initializable {

    @FXML
    Button cancelButton; //reference to cancel button

    @FXML
    Button deleteButton; //reference to delete button

    @FXML
    Button confirmButton; //reference to confirm update button

    @FXML
    TextField newAuthorName; //reference to new author name text field

    @FXML
    ComboBox<String> oldAuthorName; //reference to ComboBox that contains existing author names

    private AuthorAdapter authorsAdapter; //reference to the adapter class

    //construct adapter model
    public void setModel(AuthorAdapter name) {
        authorsAdapter = name;
        buildComboBoxData();
    }

    //close the window
    public void exitWindow() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    //update the data base table with new information the user entered
    public void confirmChanges() throws SQLException {
        authorsAdapter.editAuthor(oldAuthorName.getValue().trim(),newAuthorName.getText().trim());
        Stage stage = (Stage) confirmButton.getScene().getWindow();
        stage.close();
    }

    //delete the entire row of items from the database table
    public void deleteItem() throws SQLException {
        authorsAdapter.deleteAuthor(oldAuthorName.getValue());
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        stage.close();
    }

    //create list to fill combobox with name of author
    final ObservableList<String> data = FXCollections.observableArrayList();
    // fill list for combo box
    public void buildComboBoxData() {
        try {
            data.addAll(authorsAdapter.getAuthorNameList());
        } catch (SQLException ex) { }
    }

    // fill combobox with list of author names
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        oldAuthorName.setItems(data);
    }
}
