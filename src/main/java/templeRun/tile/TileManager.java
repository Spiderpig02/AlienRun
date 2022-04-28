package templeRun.tile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import templeRun.TempleRunApp;
import templeRun.entity.Player;
import templeRun.main.Settings;

public class TileManager {

    private Tile[] tile;
    private int mapTileNum[][];
    private Player player = Player.getInstence();
    private int counter;

    public TileManager() {
        tile = new Tile[10];
        mapTileNum = new int[Settings.maxWorldCol][Settings.maxWorldRow];

        getTileImage();
        loadMap();
    }

    private int randomTimer() {
        switch (player.getSpeed()) {
            case 3:
                return 400;
            case 5:
                return 300;
            case 7:
                return 225;
            case 9:
                return 175;
            default:
                return 600;
        }
    }

    public Tile[] getTile() {
        return tile;
    }

    public int[][] getMapTileNum() {
        return mapTileNum;
    }

    public void generateRandomObsticle() {
        if (counter == randomTimer()) {
            counter = 0;
            loadMap();
            int temp = new Random().nextInt(4);
            switch (temp) {
                case 0:
                    mapTileNum[8][1] = 3;
                    mapTileNum[8][2] = 3;
                    mapTileNum[8][3] = 2;
                    mapTileNum[8][4] = 2;
                    mapTileNum[8][5] = 3;
                    mapTileNum[8][6] = 3;
                    break;
                case 1:
                    mapTileNum[8][1] = 3;
                    mapTileNum[8][2] = 3;
                    mapTileNum[8][3] = 3;
                    mapTileNum[7][3] = 3;
                    mapTileNum[7][4] = 3;
                    mapTileNum[7][5] = 3;
                    mapTileNum[7][6] = 3;
                    mapTileNum[9][6] = 3;
                    mapTileNum[9][7] = 3;
                    break;
                case 2:
                    mapTileNum[8][1] = 3;
                    mapTileNum[8][2] = 3;
                    mapTileNum[8][3] = 3;
                    mapTileNum[9][3] = 3;
                    mapTileNum[9][4] = 3;
                    mapTileNum[7][6] = 3;
                    mapTileNum[7][7] = 3;
                    mapTileNum[7][8] = 3;
                    mapTileNum[8][7] = 3;
                    mapTileNum[8][8] = 3;
                    break;
                case 3:
                    mapTileNum[7][1] = 2;
                    mapTileNum[7][2] = 2;
                    mapTileNum[8][5] = 2;
                    mapTileNum[9][5] = 2;
                    mapTileNum[8][7] = 2;
                    mapTileNum[9][9] = 2;
                    mapTileNum[8][10] = 2;
                    mapTileNum[8][11] = 2;
                    mapTileNum[8][12] = 2;
                    break;
            }
        } else {
            counter++;
        }
    }

    private void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].setImage(new Image(TempleRunApp.class.getResource("img/Bricks.png").toExternalForm()));
            tile[1] = new Tile();
            tile[1].setImage(new Image(TempleRunApp.class.getResource("img/Sky.png").toExternalForm()));
            tile[1].setCollision(true);
            tile[2] = new Tile();
            tile[2].setImage(new Image(TempleRunApp.class.getResource("img/Stone.png").toExternalForm()));
            tile[2].setCollision(true);
            tile[3] = new Tile();
            tile[3].setImage(new Image(TempleRunApp.class.getResource("img/Water.png").toExternalForm()));
            tile[3].setCollision(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadMap() {
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
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(GraphicsContext g2) {
        int worldCol = 0;
        int worldRow = player.getWorldY() / Settings.tileSize - 20;

        while (worldCol < Settings.maxWorldCol && worldRow < player.getWorldY() / Settings.tileSize + 20) {
            int temp = Math.floorMod(worldRow, Settings.maxWorldRow);
            int tileNum = mapTileNum[worldCol][temp];

            int worldX = worldCol * Settings.tileSize;
            int worldY = worldRow * Settings.tileSize;
            int screenX = worldX - player.getWorldX() + player.getScreenX();
            int screenY = worldY - player.getWorldY() + player.getScreenY();

            // denne tegner kunn det som er på skjermen for å hjelpe med FPS
            if (worldX + Settings.tileSize > player.getWorldX() - player.getScreenX()
                    && worldX - Settings.tileSize < player.getWorldX() + player.getScreenX()
                    && worldY + Settings.tileSize > player.getWorldY() - player.getScreenY()
                    && worldY - Settings.tileSize < player.getWorldY() + player.getScreenY()) {
                g2.drawImage(tile[tileNum].getImage(), screenX, screenY, Settings.tileSize, Settings.tileSize);
            }
            worldCol++;

            if (worldCol == Settings.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }

        }
    }
}
