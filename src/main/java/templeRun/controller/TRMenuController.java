package templeRun.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import templeRun.Score;
import templeRun.VerifyClass;

public class TRMenuController extends Controller {

    @FXML
    private Button startButton;
    @FXML
    private TextField username;
    @FXML
    private ListView<Score> scoreboard;

    public void startGame() {
        System.out.println("noe");
        VerifyClass.verifyUsername(username.getText()); // sett denne inni en try catch kansje og hvis feiler så kommer
                                                        // det en popp opp. må også lage den metoden

    }

    @FXML
    public void initialize() {
        startButton.setOnAction(e -> startGame());
    }

}
