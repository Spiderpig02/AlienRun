package templeRun;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import templeRun.tile.TileManager;

public class TileManagerTest {

    private TileManager tileManager1 = new TileManager();
    private TileManager tileManager2 = new TileManager();
    private final int[][] actualStartMap = new TileManager().getMapTileNum();

    private void verifyEquals(int[][] int1, int[][] int2) {
        for (int i = 0; i < int1.length; i++) {
            for (int j = 0; j < int1[i].length; j++) {
                assertEquals(int1[i][j], int2[i][j]);
            }
        }
    }

    @DisplayName("To test if the values of the map change and make the obstacles ")
    @Test
    public void testGenrerateObstical() {
        verifyEquals(actualStartMap, tileManager1.getMapTileNum());
        tileManager1.mapChangeTiles(0);
        assertNotEquals(actualStartMap, tileManager1.getMapTileNum());
        tileManager2.mapChangeTiles(1);
        assertNotEquals(tileManager1.getMapTileNum(), tileManager2.getMapTileNum());
        tileManager1.mapChangeTiles(2);
        assertNotEquals(tileManager1.getMapTileNum(), tileManager2.getMapTileNum());
        tileManager1.loadMap();
        tileManager2.loadMap();

        tileManager1.mapChangeTiles(3);
        tileManager2.mapChangeTiles(3);
        verifyEquals(tileManager1.getMapTileNum(), tileManager2.getMapTileNum());
        tileManager1.mapChangeTiles(65432);
        tileManager2.mapChangeTiles(-4264363);
        verifyEquals(tileManager1.getMapTileNum(), tileManager2.getMapTileNum());
    }

}
