package templeRun.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyEvent;
import templeRun.entity.Player;
import templeRun.entity.Score;
import templeRun.io.KeyHandler;
import templeRun.io.SaveAndLoad;
import templeRun.io.Sound;
import templeRun.main.TempleRun;

public class TRGameController extends Controller {

    @FXML
    private Canvas game;
    @FXML
    private ListView<Score> scoreboard;
    @FXML
    private Label points;

    private KeyHandler keyHandler = new KeyHandler();
    private TempleRun tr = new TempleRun();
    private SaveAndLoad saveAndLoad = new SaveAndLoad();
    private Player player = Player.getInstence();
    private Sound gameSoud;
    private Sound speedIncrees;
    private Sound gameOver;

    public void init() {
        loadScoreboard();
        scene.setOnKeyReleased(e -> keyHandler.keyReleased(e));
        scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                keyHandler.keyPressed((e));
            };
        });
        tr.startGameThread(game, keyHandler, this);
        System.out.println(player.getUsername());
        gameSoud = new Sound();
        gameSoud.setFile(0);
        gameSoud.play();
    }

    public void updatePlayerPoints(Long points) {
        this.points.setText(String.valueOf(points));
    }

    public void playSpeed() {
        speedIncrees = new Sound();
        speedIncrees.setFile(1);
        speedIncrees.play();
        speedIncrees.stop();
    }

    public void gameOver(Score score) {
        gameOver = new Sound();
        gameSoud.stop();
        gameOver.setFile(2);
        gameOver.play();
        changeStage("fxml/GameOver.fxml", "Game Over", score);
    }

    private void loadScoreboard() {
        try {
            Collection<Score> tmp = new ArrayList<>(saveAndLoad.readSavedScoreboard().values());
            if (tmp != null) {
                List<Score> playerOnBoard = new ArrayList<>(tmp);
                Collections.sort(playerOnBoard);
                scoreboard.getItems().addAll(playerOnBoard);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

}
