package templeRun.main;

import templeRun.entity.Entity;

public class ColisionTester {
    TempleRun tr;

    public ColisionTester(TempleRun tr) {
        this.tr = tr;
    }

    public void checkTile(Entity entity) {
        int entityLeftWorldX = entity.getWorldX() + (int) entity.getSoliedSpace().getMinX();
        int entityRightWorldX = entity.getWorldX() + (int) entity.getSoliedSpace().getMaxX();
        int entityTopWorldY = entity.getWorldY() + (int) entity.getSoliedSpace().getMinY();
        int entityBottomWorldY = entity.getWorldY() + (int) entity.getSoliedSpace().getMaxY();

        int entityLeftCol = entityLeftWorldX / Settings.tileSize;
        int entityRightCol = entityRightWorldX / Settings.tileSize;
        int entityTopRow = Math.floorMod(entityTopWorldY / Settings.tileSize, Settings.maxWorldRow);
        int entityBottomRow = Math.floorMod(entityBottomWorldY / Settings.tileSize, Settings.maxWorldRow);

        int tile1, tile2;

        if (entity.getDirection().equalsIgnoreCase("up")) {
            entityTopRow = Math.floorMod((entityTopWorldY - entity.getSpeed()) / Settings.tileSize,
                    Settings.maxWorldRow);
            tile1 = tr.getTileManager().getMapTileNum()[entityLeftCol][entityTopRow];
            tile2 = tr.getTileManager().getMapTileNum()[entityRightCol][entityTopRow];
            if (tr.getTileManager().getTile()[tile1].isCollision() == true
                    || tr.getTileManager().getTile()[tile2].isCollision() == true) {
                entity.setCollisionOn(true);
            }
        } else if (entity.getDirection().equalsIgnoreCase("down")) {
            entityBottomRow = Math.floorMod((entityBottomWorldY + entity.getSpeed()) / Settings.tileSize,
                    Settings.maxWorldRow);
            tile1 = tr.getTileManager().getMapTileNum()[entityLeftCol][entityBottomRow];
            tile2 = tr.getTileManager().getMapTileNum()[entityRightCol][entityBottomRow];
            if (tr.getTileManager().getTile()[tile1].isCollision() == true
                    || tr.getTileManager().getTile()[tile2].isCollision() == true) {
                entity.setCollisionOn(true);
            }
        } else if (entity.getDirection().equalsIgnoreCase("left")) {
            entityLeftCol = (entityLeftWorldX - entity.getSpeed()) / Settings.tileSize;
            tile1 = tr.getTileManager().getMapTileNum()[entityLeftCol][entityTopRow];
            tile2 = tr.getTileManager().getMapTileNum()[entityLeftCol][entityBottomRow];
            if (tr.getTileManager().getTile()[tile1].isCollision() == true
                    || tr.getTileManager().getTile()[tile2].isCollision() == true) {
                entity.setCollisionOn(true);
            }
        } else if (entity.getDirection().equalsIgnoreCase("right")) {
            entityRightCol = (entityRightWorldX + entity.getSpeed()) / Settings.tileSize;
            tile1 = tr.getTileManager().getMapTileNum()[entityRightCol][entityTopRow];
            tile2 = tr.getTileManager().getMapTileNum()[entityRightCol][entityBottomRow];
            if (tr.getTileManager().getTile()[tile1].isCollision() == true
                    || tr.getTileManager().getTile()[tile2].isCollision() == true) {
                entity.setCollisionOn(true);
            }
        }
    }

}
