package templeRun;

import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import templeRun.controller.TRGameController;
import templeRun.entity.Player;
import templeRun.io.KeyHandler;
import templeRun.tile.TileManager;

public class TempleRun implements Runnable {

    private Thread gameThread;
    public ColisionTester colisionTester;
    private Painter paint;
    private KeyHandler keyHandler;
    private Canvas canvas;
    private Player player = Player.getInstence();
    public TileManager tileManager;
    private TRGameController controller;
    private boolean gameOver;

    public void startGameThread(Canvas canvas, KeyHandler keyHandler, TRGameController controller) {
        this.keyHandler = keyHandler;
        this.canvas = canvas;
        this.controller = controller;
        player.setPlayerThings(this, keyHandler);
        tileManager = new TileManager(canvas);
        this.paint = new Painter(canvas, player, tileManager);
        colisionTester = new ColisionTester(this);
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000 / Settings.fps;
        double delta = 0;
        Long lastTime = System.nanoTime();
        Long currentTime;
        Long timer = Long.valueOf("0");
        int drawCount = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if (delta >= 1) {
                update();
                paint.draw();
                delta--;
                drawCount++;
            }
            if (timer >= 1000000000) {
                System.out.println("FPS" + drawCount);
                drawCount = 0;
                timer = Long.valueOf("0");
            }

        }

    }

    public void setGameOver() {
        gameOver = true;
        gameThread = null;
    }

    public void switchController(Score score) {
        Platform.runLater(() -> {
            controller.gameOver(score);
        });
    }

    public void update() {
        if (!gameOver) {
            player.update();
            Platform.runLater(() -> {
                controller.updatePlayerPoints(player.getPlayerPoints());
            });
            tileManager.generateRandomObsticle();
        }
    }

    public void draw() {
        if (!gameOver) {
            paint.draw();
        }

    }

}
