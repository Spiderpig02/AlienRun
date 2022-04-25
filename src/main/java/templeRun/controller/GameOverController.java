package templeRun.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import templeRun.Score;

public class GameOverController extends Controller {
    @FXML
    private Label PlayerStats;
    @FXML
    private Button Quit, StartNewGame;

    static private Score score;

    @FXML
    public void initialize() {
        Quit.setOnAction(e -> quitGame());
        StartNewGame.setOnAction(e -> startNewGame());
        PlayerStats.setText(score.toString());
    }

    static public void setScore(Score score) {
        GameOverController.score = score;
    }

    private void quitGame() {
        getStage().close();
    }

    private void startNewGame() {
        changeStage("fxml/TempleRunMenu.fxml", "Game Menu");
    }
}
