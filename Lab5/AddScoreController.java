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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

//the controller class for AddScore.fxml
public class AddScoreController implements Initializable {
    // Some @FXML declarations
    @FXML
    Button cancelBtn; //cancel button

    @FXML
    Button saveBtn; //save button

    @FXML
    ComboBox<String> matchBox; //match selection combobox

    @FXML
    TextField hScore; //home team score text field

    @FXML
    TextField vScore; //visitor team score text field

    // The data variable is used to populate the ComboBoxes
    final ObservableList<String> data = FXCollections.observableArrayList();
    // To reference the models inside the controller
    private MatchesAdapter matchesAdapter;
    private TeamsAdapter teamsAdapter;

    public void setModel(MatchesAdapter match, TeamsAdapter team) {
        matchesAdapter = match;
        teamsAdapter = team;
        buildComboBoxData(); //add match info to the combobox
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

            String homeTeam; //home team name
            String visitorTeam; //visitor team name
            int matchNum; //match number for finding the right row to update
            //the name after the first "-" is the home team
            homeTeam = matchBox.getValue().split("-")[1].strip();
            //the name after the second "-" is the visitor team
            visitorTeam = matchBox.getValue().split("-")[2].strip();
            //the first number in the matchBox is the match number
            matchNum = Integer.parseInt(matchBox.getValue().substring(0,1));
            //Get and store the value from the text fields into variables
            int homeScore = Integer.parseInt(hScore.getText());
            int visitorScore = Integer.parseInt(vScore.getText());
            //when the save button is clicked, update scores for the selected teams
            matchesAdapter.setTeamsScore(matchNum, homeScore, visitorScore);
            teamsAdapter.setStatus(homeTeam, visitorTeam, homeScore, visitorScore);

        } catch (SQLException ex) {
            displayAlert("ERROR: " + ex.getMessage()); //error handling
        }
        //close the current window when save button is clicked
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    public void buildComboBoxData() {
        try {
            //add the current matches to data
            data.addAll(matchesAdapter.getMatchesNamesList());
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
    public void initialize(URL url, ResourceBundle resourceBundle) {
        matchBox.setItems(data); //populate the combobox
    }
}
