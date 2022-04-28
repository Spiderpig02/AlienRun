package templeRun.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import templeRun.entity.Player;
import templeRun.entity.Score;
import templeRun.entity.VerifyClass;
import templeRun.io.SaveAndLoad;

public class TRMenuController extends Controller {

    @FXML
    private Button startButton, quit;
    @FXML
    private TextField username;
    @FXML
    private ListView<Score> scoreboard;
    private Player player = Player.getInstence();
    private SaveAndLoad saveAndLoad = new SaveAndLoad();

    public void startGame() {

        while (VerifyClass.tryUsername(username.getText()) == 0) {
            alert("Not a valied username, it must contain at least one letter of number and not anny spesical signs");
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Username");
            dialog.setHeaderText("Not a valied username, pls write a new username :)");
            dialog.setContentText("USERNAME");
            String usernameFBoks = dialog.showAndWait().get();
            username.setText(usernameFBoks);
        }
        player.setUsername(username.getText());
        changeStage("fxml/TempleRunGame.fxml", "Temple Run");
    }

    private void quitGame() {
        getStage().close();
    }

    private void loadScoreboard() {
        try {
            Collection<Score> tmp = new ArrayList<>(saveAndLoad.readSavedScoreboard().values());
            if (tmp != null) {
                List<Score> playerOnBoard = new ArrayList<>(tmp);
                Collections.sort(playerOnBoard);
                scoreboard.getItems().addAll(playerOnBoard);
            }

        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        startButton.setOnAction(e -> startGame());
        quit.setOnAction((e) -> quitGame());
        loadScoreboard();
    }

}
