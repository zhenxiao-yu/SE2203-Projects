package HelloWorld;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //load the FXML file
        Parent root = FXMLLoader.load(getClass().getResource("HelloWorld.fxml"));
        primaryStage.setTitle("Hello World");
        //builds the scene graph in memory
        primaryStage.setScene(new Scene(root, 300, 275));
        //displays the GUI
        primaryStage.show();
    }

    //application main method
    public static void main(String[] args) {
        launch(args);
    }
}
