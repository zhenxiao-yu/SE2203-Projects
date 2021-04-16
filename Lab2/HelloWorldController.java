package HelloWorld;
//necessary import statements
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class HelloWorldController implements Initializable {
    @FXML
    private Label label;
    //event listener method
    @FXML
    private void handleButtonAction(ActionEvent event) {
        label.setText("Hello World!");
    }
    //automatically called after the FXML file is loaded
    @Override
    public void initialize(URL url, ResourceBundle rb) {}
}