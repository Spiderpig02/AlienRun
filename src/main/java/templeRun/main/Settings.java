package templeRun.main;

public class Settings {

    // Basic setting for game screen
    public static final int originalTileSize = 32; // 32x32 pixel art
    public static final Double scale = 1.5; // To make the tiles more visible for modern screens
    public static final int tileSize = (int) (originalTileSize * scale); // 48x48 pixel tile
    public static final int maxScreenCol = 12; // Total number of tiles on screen with
    public static final int maxScreenRow = 18; // Total number of tiles on screen height
    public static final int screenWith = tileSize * maxScreenCol; // 576 pixels
    public static final int screenHeight = tileSize * maxScreenRow; // 864 pixels

    // fps
    public static final int fps = 60;

    // World
    public static final int maxWorldCol = 17;
    public static final int maxWorldRow = 25;

}
