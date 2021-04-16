package iPublisher;
//import necessary tools
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AboutUs {
    //This is the popup window
    public static void showAboutUs() throws Exception{
        Parent popUp = FXMLLoader.load(AboutUs.class.getResource("AboutUs.fxml")); //get the fxml file
        Stage AboutUs = new Stage();  //create a new stage
        Image image = new Image("iPublisher/WesternLogo.png");  //get the Western logo image
        AboutUs.getIcons().add(image); //set western logo image as the icon for the application
        AboutUs.setTitle("About Us");   //set the title if the pop up window
        AboutUs.setResizable(false); //disable resize ability
        AboutUs.setScene(new Scene(popUp, 400, 350)); //initial size of the window
        AboutUs.show(); //display the window
    }
}
