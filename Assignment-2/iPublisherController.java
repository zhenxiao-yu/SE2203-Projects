package iPublisher;

//import necessary tools
import javafx.application.Platform;
import javafx.event.ActionEvent;

public class iPublisherController {

    //closes the application and exit system
    public void CloseApp(ActionEvent actionEvent) {
        Platform.exit();
        System.exit(0);
    }

    //Show Pop-up "About Us" Window
    public void showAbout(ActionEvent actionEvent) throws Exception {
            AboutUs.showAboutUs();
    }
}

