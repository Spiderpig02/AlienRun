package templeRun.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyEvent;
import templeRun.Score;
import templeRun.TempleRun;
import templeRun.io.KeyHandler;
import templeRun.io.SaveAndLoad;

public class TRGameController extends Controller {

    @FXML
    private Canvas game;
    @FXML
    private ListView<Score> scoreboard;
    @FXML
    private Label points;

    KeyHandler keyHandler = new KeyHandler();
    TempleRun tr = new TempleRun();
    private SaveAndLoad saveAndLoad = new SaveAndLoad();

    public void init() {
        loadScoreboard();
        scene.setOnKeyReleased(e -> keyHandler.keyReleased(e));
        scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                keyHandler.keyPressed((e));
            };
        });
        tr.startGameThread(game, keyHandler, this);
        System.out.println(tr.getPlayer().getUsername());

    }

    public void updatePlayerPoints(Long points) {
        this.points.setText(String.valueOf(points));
    }

    private void loadScoreboard() {
        try {
            Collection<Score> tmp = new ArrayList<>(saveAndLoad.readSavedScoreboard().values());
            if (tmp != null) {
                List<Score> playerOnBoard = new ArrayList<>(tmp);
                Collections.sort(playerOnBoard, Comparator.comparing(Score::getPoints));
                scoreboard.getItems().addAll(playerOnBoard);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

}
