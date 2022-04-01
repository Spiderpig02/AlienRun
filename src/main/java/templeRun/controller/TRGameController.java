package templeRun.controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ListView;
import templeRun.Score;

public class TRGameController extends Controller {

    @FXML
    private Canvas gameCanvas;
    @FXML
    private ListView<Score> scoreboard;

}
