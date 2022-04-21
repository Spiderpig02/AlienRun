package templeRun.controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import templeRun.Score;
import templeRun.TempleRun;
import templeRun.io.KeyHandler;

public class TRGameController extends Controller {

    @FXML
    private Canvas game;
    @FXML
    private ListView<Score> scoreboard;
    @FXML
    private Label points;

    KeyHandler keyHandler = new KeyHandler();
    TempleRun tr = new TempleRun();

    public void init() {
        scene.setOnKeyPressed(e -> keyHandler.keyPressed(e));
        scene.setOnKeyReleased(e -> keyHandler.keyReleased(e));
        tr.startGameThread(game, keyHandler, this);
        System.out.println(tr.getPlayer().getUsername());

    }

    public void updatePlayerPoints(Long points) {
        this.points.setText(String.valueOf(points));
    }

}
