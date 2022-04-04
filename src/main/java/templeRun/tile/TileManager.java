package templeRun.tile;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import templeRun.Settings;
import templeRun.TempleRunApp;

public class TileManager {

    private Canvas canvas;
    private Tile[] tile;

    public TileManager(Canvas canvas) {
        this.canvas = canvas;
        tile = new Tile[10];

        getTileImage();
    }

    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = new Image(TempleRunApp.class.getResource("img/bricks.png").toExternalForm());
            tile[1] = new Tile();
            tile[1].image = new Image(TempleRunApp.class.getResource("img/sky.png").toExternalForm());
            tile[2] = new Tile();
            tile[2].image = new Image(TempleRunApp.class.getResource("img/stone.png").toExternalForm());
            tile[3] = new Tile();
            tile[3].image = new Image(TempleRunApp.class.getResource("img/water.png").toExternalForm());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(GraphicsContext g2) {
        g2.drawImage(tile[0].image, 0, 0, Settings.tileSize, Settings.tileSize);
        g2.drawImage(tile[1].image, 48, 0, Settings.tileSize, Settings.tileSize);
        g2.drawImage(tile[2].image, 96, 0, Settings.tileSize, Settings.tileSize);
        g2.drawImage(tile[3].image, 144, 0, Settings.tileSize, Settings.tileSize);
    }
}
