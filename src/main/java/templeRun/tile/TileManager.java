package templeRun.tile;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import templeRun.Settings;
import templeRun.TempleRunApp;

public class TileManager {

    private Canvas canvas;
    private Tile[] tile;
    private int mapTileNum[][];

    public TileManager(Canvas canvas) {
        this.canvas = canvas;
        tile = new Tile[10];
        mapTileNum = new int[Settings.maxScreenCol + 2][Settings.maxScreenRow + 2];

        getTileImage();
        loadMap();
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

    public void loadMap() {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(TempleRunApp.class.getResourceAsStream("map/map.txt")))) {
            int col = 0;
            int row = 0;

            while (col < Settings.maxScreenCol && row < Settings.maxScreenRow) {
                String line = br.readLine();
                while (col < Settings.maxScreenCol) {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == Settings.maxScreenCol) {
                    col = 0;
                    row++;
                }
                System.out.println("har laste map");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(GraphicsContext g2) {
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < Settings.maxScreenCol && row < Settings.maxScreenRow) {
            int tileNum = mapTileNum[col][row];

            g2.drawImage(tile[tileNum].image, x, y, Settings.tileSize, Settings.tileSize);
            col++;
            x += Settings.tileSize;

            if (col == Settings.maxScreenCol) {
                col = 0;
                x = 0;
                row++;
                y += Settings.tileSize;
            }

        }
    }
}
