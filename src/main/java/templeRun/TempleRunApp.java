package templeRun;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import templeRun.controller.Controller;

public class TempleRunApp extends Application {

    @Override
    public void start(Stage root) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/TempleRunMenu.fxml"));
        root.setTitle("Game Menu");
        root.setScene(new Scene(loader.load()));
        ((Controller) loader.getController()).setStage(root);
        root.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
