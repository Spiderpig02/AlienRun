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
        Scene scene = new Scene(loader.load());
        root.setScene(scene);
        Controller controller = loader.getController();
        controller.setStage(root);
        controller.setScene(scene);
        controller.init();
        root.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
