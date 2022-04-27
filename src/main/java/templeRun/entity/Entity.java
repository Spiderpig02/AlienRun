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

    protected Image getUp1() {
        return up1;
    }

    protected void setUp1(Image up1) {
        this.up1 = up1;
    }

    protected Image getUp2() {
        return up2;
    }

    protected void setUp2(Image up2) {
        this.up2 = up2;
    }

    protected Image getDown1() {
        return down1;
    }

    protected void setDown1(Image down1) {
        this.down1 = down1;
    }

    protected Image getDown2() {
        return down2;
    }

    protected void setDown2(Image down2) {
        this.down2 = down2;
    }

    protected Image getLeft1() {
        return left1;
    }

    protected void setLeft1(Image left1) {
        this.left1 = left1;
    }

    protected Image getLeft2() {
        return left2;
    }

    protected void setLeft2(Image left2) {
        this.left2 = left2;
    }

    protected Image getRight1() {
        return right1;
    }

    protected void setRight1(Image right1) {
        this.right1 = right1;
    }

    protected Image getRight2() {
        return right2;
    }

    protected void setRight2(Image right2) {
        this.right2 = right2;
    }

    public String getDirection() {
        return direction;
    }

    protected void setDirection(String direction) {
        if (direction.equals("up") || direction.equals("down") || direction.equals("left")
                || direction.equals("right")) {
            this.direction = direction;
        }
    }

    protected int getSpriteCounter() {
        return spriteCounter;
    }

    protected void setSpriteCounter(int spriteCounter) {
        this.spriteCounter = spriteCounter;
    }

    protected int getSpriteNum() {
        return spriteNum;
    }

    protected void setSpriteNum(int spriteNum) {
        this.spriteNum = spriteNum;
    }

    public Rectangle2D getSoliedSpace() {
        return soliedSpace;
    }

    protected void setSoliedSpace(Rectangle2D soliedSpace) {
        this.soliedSpace = soliedSpace;
    }

    public boolean isCollisionOn() {
        return collisionOn;
    }

    public void setCollisionOn(boolean collisionOn) {
        this.collisionOn = collisionOn;
    }

}
