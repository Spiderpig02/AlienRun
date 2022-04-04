package templeRun.tile;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import templeRun.Settings;
import templeRun.TempleRunApp;
import templeRun.entity.Player;

public class TileManager {

    private Canvas canvas;
    private Tile[] tile;
    private int mapTileNum[][];
    private Player player = Player.getInstence();

    public TileManager(Canvas canvas) {
        this.canvas = canvas;
        tile = new Tile[10];
        mapTileNum = new int[Settings.maxWorldCol][Settings.maxWorldRow];

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
                new InputStreamReader(TempleRunApp.class.getResourceAsStream("map/worldMap17x100.txt")))) {
            int col = 0;
            int row = 0;

            while (col < Settings.maxWorldCol && row < Settings.maxWorldRow) {
                String line = br.readLine();
                while (col < Settings.maxWorldCol) {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == Settings.maxWorldCol) {
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
        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < Settings.maxWorldCol && worldRow < Settings.maxWorldRow) {
            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * Settings.tileSize;
            int worldY = worldRow * Settings.tileSize;
            int screenX = worldX - player.getWorldX() + player.getScreenX();
            int screenY = worldY - player.getWorldY() + player.getScreenY();

            // denne tenger kunn det som er på skjermen for å hjelpe med FPS
            if (worldX + Settings.tileSize > player.getWorldX() - player.getScreenX()
                    && worldX - Settings.tileSize < player.getWorldX() + player.getScreenX()
                    && worldY + Settings.tileSize > player.getWorldY() - player.getScreenY()
                    && worldY - Settings.tileSize < player.getWorldY() + player.getScreenY()) {
                g2.drawImage(tile[tileNum].image, screenX, screenY, Settings.tileSize, Settings.tileSize);
            }
            worldCol++;

            if (worldCol == Settings.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }

        }
    }
}
