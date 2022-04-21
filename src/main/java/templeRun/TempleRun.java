package templeRun;

import javafx.scene.canvas.Canvas;
import templeRun.controller.TRGameController;
import templeRun.entity.Player;
import templeRun.io.KeyHandler;
import templeRun.tile.TileManager;

public class TempleRun implements Runnable {

    private Thread gameThread;
    public ColisionTester colisionTester;
    Painter paint;
    KeyHandler keyHandler;
    Canvas canvas;
    private Player player = Player.getInstence();
    TileManager tileManager;
    private TRGameController controller;

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

    public Player getPlayer() {
        return this.player;
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

    public void update() {
        player.update();
        controller.updatePlayerPoints(player.getPlayerPoints());
    }

    public void draw() {
        paint.draw();

    }

}
