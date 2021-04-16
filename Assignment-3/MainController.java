package iPublisher;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Abdelkader
 */
public class MainController implements Initializable {

    private TitleAdapter titles;        //reference to Title adapter class
    private AuthorAdapter authors;      //reference to Author Adapter class
    private PublisherUnitAdapter publisherUnits;  //reference to Publisher Unit Adapter class
    private Connection conn;        //used to establish connection to database

    @FXML
    private MenuBar mainMenu; //reference to the menu bar


    //show the About Us widow
    public void showAbout() throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("About.fxml"));
        Parent About = (Parent) fxmlLoader.load();

        Scene scene = new Scene(About);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iPublisher/WesternLogo.png"));
        stage.setTitle("About Us");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    //display the add new author window
    public void showAddNewAuthor() throws Exception {
        authors = new AuthorAdapter(conn, false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddAuthor.fxml"));
        Parent AddNewAuthor = (Parent) fxmlLoader.load();

        AddAuthorController addAuthorController = (AddAuthorController) fxmlLoader.getController();
        addAuthorController.setModel(authors);

        Scene scene = new Scene(AddNewAuthor);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iPublisher/WesternLogo.png"));
        stage.setTitle("Add New Author");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    //display the add new title window
    public void showAddNewTitle() throws Exception {
        titles = new TitleAdapter(conn, false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddTitle.fxml"));
        Parent AddNewTitle = (Parent) fxmlLoader.load();

        AddTitleController addTitleController = (AddTitleController) fxmlLoader.getController();
        addTitleController.setModel(titles);

        Scene scene = new Scene(AddNewTitle);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iPublisher/WesternLogo.png"));
        stage.setTitle("Add New Title");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    //display the add new author window
    public void showAddNewPublisherUnit() throws Exception {
        publisherUnits = new PublisherUnitAdapter(conn, false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddPublisherUnit.fxml"));
        Parent AddNewPublisherUnit = (Parent) fxmlLoader.load();

        AddPublisherUnitController addPublisherUnitController = (AddPublisherUnitController) fxmlLoader.getController();
        addPublisherUnitController.setModel(publisherUnits);

        Scene scene = new Scene(AddNewPublisherUnit);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iPublisher/WesternLogo.png"));
        stage.setTitle("Add New Publisher Unit");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    //display the edit/delete author window
    public void showEditDeleteAuthor() throws Exception {
        authors = new AuthorAdapter(conn, false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditDeleteAuthor.fxml"));
        Parent editDeleteAuthor = (Parent) fxmlLoader.load();

        EditDeleteAuthorController editDeleteAuthorController = (EditDeleteAuthorController) fxmlLoader.getController();
        editDeleteAuthorController.setModel(authors);

        Scene scene = new Scene(editDeleteAuthor);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iPublisher/WesternLogo.png"));
        stage.setTitle("Edit/Delete Author");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    //display the edit/delete title window
    public void showEditDeleteTitle() throws Exception {
        titles = new TitleAdapter(conn, false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditDeleteTitle.fxml"));
        Parent EditDeleteTitle = (Parent) fxmlLoader.load();

        EditDeleteTitleController editDeleteTitleController = (EditDeleteTitleController) fxmlLoader.getController();
        editDeleteTitleController.setModel(titles);

        Scene scene = new Scene(EditDeleteTitle);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iPublisher/WesternLogo.png"));
        stage.setTitle("Edit/Delete Title");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    //display the edit/delete publisher unit window
    public void showEditDeletePublisherUnit() throws Exception {
        publisherUnits = new PublisherUnitAdapter(conn, false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditDeletePublisherUnit.fxml"));
        Parent EditDeletePublisherUnit = (Parent) fxmlLoader.load();

        EditDeletePublisherUnitController editDeletePublisherUnitController = (EditDeletePublisherUnitController) fxmlLoader.getController();
        editDeletePublisherUnitController.setModel(publisherUnits);

        Scene scene = new Scene(EditDeletePublisherUnit);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iPublisher/WesternLogo.png"));
        stage.setTitle("Edit/Delete Publisher Unit");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    //exit the application by closing down the window
    public void exit() {
        Stage stage = (Stage) mainMenu.getScene().getWindow();
        stage.close();
    }


    //used to reset the data base
    @FXML
    public void resetDB() {
        try {
            // create Authors model
            authors = new AuthorAdapter(conn, true);
            displayAlert("Authors table has been created");

        } catch (SQLException ex) {
            displayAlert("ERROR: " + ex.getMessage());
        }

        try {
            // create PublisherUnits model
            publisherUnits = new PublisherUnitAdapter(conn, true);
            displayAlert("PublisherUnits table has been reset");

        } catch (SQLException ex) {
            displayAlert("ERROR: " + ex.getMessage());
        }

        try {
            // create Titles model
            titles = new TitleAdapter(conn, true);
            displayAlert("Titles table has been reset");

        } catch (SQLException ex) {
            displayAlert("ERROR: " + ex.getMessage());
        }
    }


    //show alert box when an error occurs
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


    //initialize the iPublisher data base
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // Create a named constant for the URL
            // NOTE: This value is specific for Java DB
            String DB_URL = "jdbc:derby:iPublisherDB;create=true";
            // Create a connection to the database
            conn = DriverManager.getConnection(DB_URL);

        } catch (SQLException ex) {
            displayAlert(ex.getMessage());
        }

    }

}

