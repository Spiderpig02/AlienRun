package templeRun;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TempleRunApp extends Application {

    @Override
    public void start(Stage root) throws IOException {
        root.setTitle("Temple Run");
        root.setScene(new Scene(FXMLLoader.load(getClass().getResource("TempleRun.fxml"))));
        root.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
