package templeRun;

public class Settings {

    // Basic setting for game screen
    private static final int originalTileSize = 32; // 32x32 pixel art
    private static final Double scale = 1.5; // To make the tiles more visible for modern screens
    private static final int tileSize = (int) (originalTileSize * scale); // 48x48 pixel tile
    private static final int maxScreenCol = 12; // Total number of tiles on screen with
    private static final int maxScreenRow = 18; // Total number of tiles on screen height
    private static final int screenWith = tileSize * maxScreenCol; // 576 pixels
    private static final int screenHeight = tileSize * maxScreenRow; // 864 pixels

}
