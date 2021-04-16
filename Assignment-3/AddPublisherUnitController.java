package iPublisher;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class AddPublisherUnitController {

    @FXML
    Button cancelButton; //reference to cancel button

    @FXML
    Button addButton;  //reference to add button

    @FXML
    TextField employeeName; //reference to employeeName text field

    @FXML
    TextField employeeId; //reference to employeeId text field

    @FXML
    TextField branchName; //reference to branchName text field

    private PublisherUnitAdapter publisherUnitAdapter;


    //construct adapter for model class
    public void setModel(PublisherUnitAdapter publisherUnit) {
        this.publisherUnitAdapter = publisherUnit;
    }

    //close current window when cancel button is clicked
    public void exitWindow() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    //save and add new publisher units to database table
    @FXML
    public void save() {
        try {
            publisherUnitAdapter.insertPublisherUnit(employeeName.getText(), employeeId.getText(),branchName.getText());
        } catch (SQLException ex) {
            displayAlert("ERROR: " + ex.getMessage());
        }
        //close window after item is inserted
        Stage stage = (Stage) addButton.getScene().getWindow();
        stage.close();
    }

    //show alert box when there is an error
    private void displayAlert(String msg) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Alert.fxml"));
            Parent ERROR = loader.load();
            AlertController controller = (AlertController) loader.getController();

            Scene scene = new Scene(ERROR);
            Stage stage = new Stage();
            stage.setScene(scene);

            stage.getIcons().add(new Image("file:src/iPublisher/WesternLogo.png"));
            controller.setAlertText(msg);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

        } catch (IOException ex1) {

        }
    }
}
