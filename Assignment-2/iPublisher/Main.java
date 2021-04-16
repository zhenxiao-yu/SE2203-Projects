package iPublisher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class Main extends Application {
    //This is the main application
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("iPublisher.fxml")); //get the fxml file
        Image image = new Image("iPublisher/WesternLogo.png"); //get the western logo image
        primaryStage.getIcons().add(image); //set western logo image as the icon for the application
        primaryStage.setTitle("iPublisher"); //set the title of the application
        primaryStage.setScene(new Scene(root, 1100, 700)); //initial size of the window
        primaryStage.show();  //display the window
    }


    public static void main(String[] args) {
        launch(args);
    }
}
