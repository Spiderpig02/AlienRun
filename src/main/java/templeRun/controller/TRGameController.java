package templeRun.controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ListView;
import templeRun.Score;
import templeRun.io.KeyHandler;

public class TRGameController extends Controller {

    @FXML
    private Canvas game;
    @FXML
    private ListView<Score> scoreboard;

    KeyHandler keyHandler;

    public Canvas getCanvas() {
        return this.game;
    }

    @FXML
    public void initialize() {
        game.requestFocus();
        game.setOnKeyPressed(e -> keyHandler.keyPressed(e));
        game.setOnKeyReleased(e -> keyHandler.keyReleased(e));
    }

}
