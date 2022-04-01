package templeRun;

public class Settings {

    // Basic setting for game screen
    private static final int originalTileSize = 32; // 32x32 pixel art
    private static final int scale = 2; // To make the tiles more visible for modern screens
    private static final int tileSize = originalTileSize * scale; // 64x64 pixel tile
    private static final int maxScreenCol = 12; // Total number of tiles on screen with
    private static final int maxScreenRow = 18; // Total number of tiles on screen height
    private static final int screenWith = tileSize * maxScreenCol; // 768 pixels
    private static final int screenHeight = tileSize * maxScreenRow; // 1152 pixels


    
}
