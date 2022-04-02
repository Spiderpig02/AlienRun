package templeRun;

import javafx.stage.Stage;
import templeRun.controller.TRGameController;

public class TempleRun implements Runnable {

    private Thread gameThread;
    TRGameController gameController = new TRGameController();
    private Stage stage = gameController.getStage();

    public void startGameThread() {
        gameThread = new Thread(this);
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

    }

}
