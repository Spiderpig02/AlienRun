package templeRun;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import templeRun.entity.Player;

public class Painter {
    Canvas canvas;
    GraphicsContext gc;
    Player player;

    public Painter(Canvas canvas, Player player) {
        this.canvas = canvas;
        this.gc = canvas.getGraphicsContext2D();
        this.player = player;
    }

    public void draw() {
        gc.fillRect(100, 100, 50, 50);
    }
}
