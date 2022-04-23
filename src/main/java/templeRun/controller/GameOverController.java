package templeRun.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GameOverController extends Controller {
    @FXML
    private Label PlayerStats;
    @FXML
    private Button Quit, StartNewGame;

    @FXML
    public void initialize() {
        Quit.setOnAction(e -> quitGame());
        StartNewGame.setOnAction(e -> startNewGame());
        PlayerStats.setText(super.getScore().toString());
    }

    private void quitGame() {
        getStage().close();
    }

    private void startNewGame() {
        changeStage("fxml/TempleRunMenu.fxml", "Game Menu");
    }
}
