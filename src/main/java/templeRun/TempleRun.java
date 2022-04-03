package templeRun;

import javafx.scene.canvas.Canvas;

public class TempleRun implements Runnable {

    private Thread gameThread;
    Painter paint;

    public void startGameThread(Canvas canvas) {
        this.paint = new Painter(canvas);
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        while (gameThread != null) {

            update();
            paint.draw();
            System.out.println("check");

        }

    }

    public void update() {

    }

    public void draw() {
        // GraphicsContext gc = canvas.getGraphicsContext2D();

        // gc.fillRect(100, 100, 50, 50);

    }

}
