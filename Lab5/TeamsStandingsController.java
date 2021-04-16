package TennisBallGames;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Abdelkader
 */
public class TeamsStandingsController implements Initializable {

    //TABLE VIEW AND DATA
    private TeamsAdapter teamsAdapter;

    @FXML
    private TableView<Teams> tableView;
    @FXML
    private TableColumn<Teams, String> teamNameCol;
    @FXML
    private TableColumn<Teams, Integer> winsCol;
    @FXML
    private TableColumn<Teams, Integer> lossesCol;
    @FXML
    private TableColumn<Teams, Integer> tiesCol;

    final ObservableList<Teams> data = FXCollections.observableArrayList();

    public void setModel(TeamsAdapter team) {

        teamsAdapter = team;
        buildData();

    }

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

    @FXML
    public void buildData() {
        try {
            data.addAll(teamsAdapter.getTeamsList());
        } catch (SQLException ex) {
            displayAlert("ERROR: " + ex.getMessage());
        }
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        teamNameCol.setCellValueFactory(cellData -> cellData.getValue().teamNameProperty());
        winsCol.setCellValueFactory(cellData -> cellData.getValue().winsProperty().asObject());
        lossesCol.setCellValueFactory(cellData -> cellData.getValue().lossesProperty().asObject());
        tiesCol.setCellValueFactory(cellData -> cellData.getValue().tiesProperty().asObject());

        tableView.setItems(data);

    }

}
