package templeRun.main;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import templeRun.entity.Player;
import templeRun.tile.TileManager;

public class Painter {
    private GraphicsContext gc;
    private Player player;
    private TileManager tileManager;

    public Painter(Canvas canvas, Player player, TileManager tileManager) {
        this.gc = canvas.getGraphicsContext2D();
        this.player = player;
        this.tileManager = tileManager;
    }

    public void draw() {
        tileManager.draw(gc);
        player.draw(gc);
    }
}
