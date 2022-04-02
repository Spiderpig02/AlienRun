package templeRun.controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ListView;
import templeRun.Score;

public class TRGameController extends Controller {

    @FXML
    private Canvas game;
    @FXML
    private ListView<Score> scoreboard;

    @FXML
    public void initialize() {
        game.setOnKeyPressed(e -> );
    }

}
