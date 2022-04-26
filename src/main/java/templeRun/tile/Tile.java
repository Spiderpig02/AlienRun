package templeRun.tile;

import javafx.scene.image.Image;

public class Tile {

    private Image image;
    private boolean collision = false;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean isCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }
}
