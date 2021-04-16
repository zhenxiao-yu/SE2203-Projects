package SampleHandler;
import java.util.Random;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
public class SampleHandlerController {
    @FXML
    private Label jumpingLabel;

    public void movingLabel(){
        //generate a random position
        Random randomPos = new Random();
        //generate boundaries for the random position
        jumpingLabel.setLayoutX(randomPos.nextInt(500));
        jumpingLabel.setLayoutY(randomPos.nextInt(300));
    }
}
