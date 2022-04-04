package templeRun.controller;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import templeRun.TempleRunApp;

public abstract class Controller {

    private Stage stage;
    protected Scene scene;

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void changeStage(String fxml) {
        this.changeStage(fxml, null);
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void alert(String alertMessage) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("There is an problem with you username");
        alert.setContentText(alertMessage);
        alert.showAndWait();
    }

    public void changeStage(String fxml, String title) {
        FXMLLoader loader = new FXMLLoader(TempleRunApp.class.getResource(fxml));
        try {
            this.scene = new Scene(loader.load());
            this.stage.setScene(this.scene);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Controller controller = loader.getController();
        controller.setStage(this.stage);
        controller.setScene(this.scene);
        if (title != null) {
            this.stage.setTitle(title);
        }
        controller.init();
    }

    public void init() {

    }
}
