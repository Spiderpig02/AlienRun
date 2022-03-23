package templeRun;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class TempleRunController extends AnchorPane {

    @FXML
    private Canvas gameCanvas;
    private Button startButton;
    private TextField username;
    private ListView<Score> scoreboard;

    public void startGame() {
        GraphicsContext gc = gameCanvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 250, 400);
    }

}
