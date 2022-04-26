package templeRun.entity;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

public abstract class Entity {

    private int worldX, worldY;
    private int speed;
    private Image up1, up2, down1, down2, left1, left2, right1, right2;
    private String direction;

    private int spriteCounter = 0;
    private int spriteNum = 1;

    private Rectangle2D soliedSpace;
    private boolean collisionOn = false;

    public int getWorldX() {
        return worldX;
    }

    public void setWorldX(int worldX) {
        this.worldX = worldX;
    }

    public int getWorldY() {
        return worldY;
    }

    public void setWorldY(int worldY) {
        this.worldY = worldY;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if (speed >= 0) {
            this.speed = speed;
        }
    }

    public Image getUp1() {
        return up1;
    }

    public void setUp1(Image up1) {
        this.up1 = up1;
    }

    public Image getUp2() {
        return up2;
    }

    public void setUp2(Image up2) {
        this.up2 = up2;
    }

    public Image getDown1() {
        return down1;
    }

    public void setDown1(Image down1) {
        this.down1 = down1;
    }

    public Image getDown2() {
        return down2;
    }

    public void setDown2(Image down2) {
        this.down2 = down2;
    }

    public Image getLeft1() {
        return left1;
    }

    public void setLeft1(Image left1) {
        this.left1 = left1;
    }

    public Image getLeft2() {
        return left2;
    }

    public void setLeft2(Image left2) {
        this.left2 = left2;
    }

    public Image getRight1() {
        return right1;
    }

    public void setRight1(Image right1) {
        this.right1 = right1;
    }

    public Image getRight2() {
        return right2;
    }

    public void setRight2(Image right2) {
        this.right2 = right2;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        if (direction.equals("up") || direction.equals("down") || direction.equals("left")
                || direction.equals("right")) {
            this.direction = direction;
        }
    }

    public int getSpriteCounter() {
        return spriteCounter;
    }

    public void setSpriteCounter(int spriteCounter) {
        this.spriteCounter = spriteCounter;
    }

    public int getSpriteNum() {
        return spriteNum;
    }

    public void setSpriteNum(int spriteNum) {
        this.spriteNum = spriteNum;
    }

    public Rectangle2D getSoliedSpace() {
        return soliedSpace;
    }

    public void setSoliedSpace(Rectangle2D soliedSpace) {
        this.soliedSpace = soliedSpace;
    }

    public boolean isCollisionOn() {
        return collisionOn;
    }

    public void setCollisionOn(boolean collisionOn) {
        this.collisionOn = collisionOn;
    }

}
