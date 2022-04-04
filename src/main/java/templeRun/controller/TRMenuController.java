package templeRun.controller;

import java.util.NoSuchElementException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import templeRun.Score;
import templeRun.VerifyClass;
import templeRun.entity.Player;

public class TRMenuController extends Controller {

    @FXML
    private Button startButton;
    @FXML
    private TextField username;
    @FXML
    private ListView<Score> scoreboard;
    private Player player = Player.getInstence();

    public void startGame() {
        System.out.println("noe");
        String tempString = username.getText();
        System.out.println(tempString);
        System.out.println("noe 2");
        try {
            VerifyClass.verifyUsername(username.getText());
        } catch (IllegalArgumentException e) {
            alert(e.getMessage());
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Username");
            dialog.setHeaderText("Not a valied username, pls write a new username :)");
            dialog.setContentText("USERNAME");
            String usernameFBoks = dialog.showAndWait().get();
            username.setText(usernameFBoks);
            startGame();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        player.setUsername(tempString);
        changeStage("fxml/TempleRunGame.fxml", "Temple Run");

    }

    @FXML
    public void initialize() {
        startButton.setOnAction(e -> startGame());
    }

}
