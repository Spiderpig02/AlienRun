package templeRun;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Painter {
    Canvas canvas;
    GraphicsContext gc;

    public Painter(Canvas canvas) {
        this.canvas = canvas;
        this.gc = canvas.getGraphicsContext2D();
    }
    

    public void draw() {
        gc.fillRect(100, 100, 50, 50);
    }
}
