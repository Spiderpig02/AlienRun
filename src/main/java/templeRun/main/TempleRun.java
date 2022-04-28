package templeRun.main;

import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import templeRun.controller.TRGameController;
import templeRun.entity.Player;
import templeRun.entity.Score;
import templeRun.io.KeyHandler;
import templeRun.tile.TileManager;

public class TempleRun implements Runnable {

    private Thread gameThread;
    private ColisionTester colisionTester;
    private Painter paint;
    private Player player = Player.getInstence();
    private TileManager tileManager = new TileManager();
    private TRGameController controller;
    private boolean gameOver;

    public void startGameThread(Canvas canvas, KeyHandler keyHandler, TRGameController controller) {
        this.controller = controller;
        player.setPlayerThings(this, keyHandler);
        this.paint = new Painter(canvas, player, tileManager);
        colisionTester = new ColisionTester(this);
        gameThread = new Thread(this);
        gameThread.start();
    }

    public ColisionTester getColisionTester() {
        return colisionTester;
    }

    public TileManager getTileManager() {
        return tileManager;
    }

    @Override
    public void run() {

        double drawInterval = 1000000000 / Settings.fps;
        double delta = 0;
        Long lastTime = System.nanoTime();
        Long currentTime;
        Long timer = 0L;
        int drawCount = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if (delta >= 1) {
                update();
                draw();
                delta--;
                drawCount++;
            }
            if (timer >= 1000000000) {
                System.out.println("FPS" + drawCount);
                drawCount = 0;
                timer = 0L;
            }

        }

    }

    public void setGameOver() {
        gameOver = true;
        gameThread = null;
    }

    public void speedIncrees() {
        Platform.runLater(() -> {
            controller.playSpeed();
        });
    }

    public void switchController(Score score) {
        Platform.runLater(() -> {
            controller.gameOver(score);
        });
    }

    private void update() {
        if (!gameOver) {
            player.update();
            Platform.runLater(() -> {
                controller.updatePlayerPoints(player.getPlayerPoints());
            });
            tileManager.generateRandomObsticle();
        }
    }

    private void draw() {
        if (!gameOver) {
            paint.draw();
        }

    }

}
