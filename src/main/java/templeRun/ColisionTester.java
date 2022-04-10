package templeRun;

import templeRun.entity.Entity;

public class ColisionTester {
    TempleRun tr;

    public ColisionTester(TempleRun tr) {
        this.tr = tr;
    }

    public void checkTile(Entity entity) {
        int entityLeftWorldX = entity.worldX + (int) entity.soliedSpace.getMinX();
        int entityRightWorldX = entity.worldX + (int) entity.soliedSpace.getMaxX();
        int entityTopWorldY = entity.worldY + (int) entity.soliedSpace.getMinY();
        int entityBottomWorldY = entity.worldY + (int) entity.soliedSpace.getMaxY();

        int entityLeftCol = entityLeftWorldX / Settings.tileSize;
        int entityRightCol = entityRightWorldX / Settings.tileSize;
        int entityTopRow = entityTopWorldY / Settings.tileSize;
        int entityBottomRow = entityBottomWorldY / Settings.tileSize;

        int tile1, tile2;

        if (entity.direction.equalsIgnoreCase("up")) {
            entityTopRow = (entityTopWorldY - entity.speed) / Settings.tileSize;
            tile1 = tr.tileManager.mapTileNum[entityLeftCol][entityTopRow];
            tile2 = tr.tileManager.mapTileNum[entityRightCol][entityTopRow];
            if (tr.tileManager.tile[tile1].collision == true || tr.tileManager.tile[tile2].collision == true) {
                entity.collisionOn = true;
            }
        } else if (entity.direction.equalsIgnoreCase("down")) {
            entityBottomRow = (entityBottomWorldY + entity.speed) / Settings.tileSize;
            tile1 = tr.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
            tile2 = tr.tileManager.mapTileNum[entityRightCol][entityBottomRow];
            if (tr.tileManager.tile[tile1].collision == true || tr.tileManager.tile[tile2].collision == true) {
                entity.collisionOn = true;
            }
        } else if (entity.direction.equalsIgnoreCase("left")) {
            entityLeftCol = (entityLeftWorldX - entity.speed) / Settings.tileSize;
            tile1 = tr.tileManager.mapTileNum[entityLeftCol][entityTopRow];
            tile2 = tr.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
            if (tr.tileManager.tile[tile1].collision == true || tr.tileManager.tile[tile2].collision == true) {
                entity.collisionOn = true;
            }
        } else if (entity.direction.equalsIgnoreCase("right")) {
            entityRightCol = (entityRightWorldX + entity.speed) / Settings.tileSize;
            tile1 = tr.tileManager.mapTileNum[entityRightCol][entityTopRow];
            tile2 = tr.tileManager.mapTileNum[entityRightCol][entityBottomRow];
            if (tr.tileManager.tile[tile1].collision == true || tr.tileManager.tile[tile2].collision == true) {
                entity.collisionOn = true;
            }
        }
    }

}
