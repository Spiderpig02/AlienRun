package templeRun;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class TempleRunController extends AnchorPane{

    @FXML
    private Canvas gameCanvas;
    private Button startButton;
    private TextField username;
    private ListView<Score> scoreboard;

}
