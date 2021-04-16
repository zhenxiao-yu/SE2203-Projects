package TennisBallGames;
// import the required libraries
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

//the controller class for addMatch.fxml
public class AddMatchController implements Initializable {
    // Some @FXML declarations
    @FXML
    Button cancelBtn; //cancel button

    @FXML
    Button saveBtn; //save button

    @FXML
    ComboBox homeTeamBox; //home team combobox

    @FXML
    ComboBox visitorTeamBox; //visitor team combobox

    // The data variable is used to populate the ComboBoxes
    final ObservableList<String> data = FXCollections.observableArrayList();
    // To reference the models inside the controller
    private MatchesAdapter matchesAdapter;
    private TeamsAdapter teamsAdapter;

    public void setModel(MatchesAdapter match, TeamsAdapter team) {
        matchesAdapter = match;
        teamsAdapter = team;
        buildComboBoxData();   //add match info to the combobox
    }

    //the cancel method is called when the cancel button is clicked
    @FXML
    public void cancel() {
        //close the current window when cancel button is clicked
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    //the save method is called when the save button is clicked
    @FXML
    public void save() {
        try {
            matchesAdapter.insertMatch(matchesAdapter.getMax() + 1, //increment the match number by 1 when a game is added
                    //use the values selected in the combobox
                    homeTeamBox.getValue().toString(),
                    visitorTeamBox.getValue().toString());
        } catch (SQLException ex) {
            displayAlert("ERROR: " + ex.getMessage()); //error handling
        }
        //close the current window when save button is clicked
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    public void buildComboBoxData() {
        try {
            //add the current team names to data
            data.addAll(teamsAdapter.getTeamsNames());
        } catch (SQLException ex) {
            displayAlert("ERROR: " + ex.getMessage()); //error handling
        }
    }

    //show alert box
    private void displayAlert(String msg) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Alert.fxml"));
            Parent ERROR = loader.load();
            AlertController controller = (AlertController) loader.getController();

            Scene scene = new Scene(ERROR);
            Stage stage = new Stage();
            stage.setScene(scene);

            stage.getIcons().add(new Image("file:src/TennisBallGames/WesternLogo.png"));
            controller.setAlertText(msg);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

        } catch (IOException ex1) {

        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        homeTeamBox.setItems(data);
        visitorTeamBox.setItems(data); //populate the combobox
    }
}