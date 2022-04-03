package templeRun;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import templeRun.controller.TRGameController;

public class TempleRun implements Runnable {

    private Thread gameThread;
    TRGameController gameController = new TRGameController();
    private Stage stage;
    private Canvas canvas;

    public void startGameThread() {
        gameThread = new Thread(this);
        this.stage = gameController.getStage();
        this.canvas = gameController.getCanvas();
        gameThread.start();
    }

    @Override
    public void run() {

        while (gameThread != null) {

            update();
            draw();

        }

    }

    public void update() {

    }

    public void draw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();

    }

}
