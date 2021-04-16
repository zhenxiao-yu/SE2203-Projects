package TennisBallGames;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

import javafx.stage.Stage;

/**
 *
 * @author Abdelkader
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainForm.fxml"));

        Scene scene = new Scene(root);

        stage.getIcons().add(new Image("file:src/TennisBallGames/WesternLogo.png"));
        stage.setTitle("Tennis Ball Games");

        stage.setScene(scene);
        stage.show();
    }



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
