package iPublisher;

//import necessary tools
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

//Controller class for About Us pop up window
public class AboutUsController {
    //reference to "OK" button with the id "closeButton"
    public Button closeButton;

    //Close the pop up window
    public void CloseAboutUs(ActionEvent actionEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow(); //get the window the button is located on
        stage.close();  //close the window
    }
}
