package templeRun.entity;

import java.io.IOException;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import templeRun.Settings;
import templeRun.TempleRunApp;
import templeRun.io.KeyHandler;

public class Player extends Entity {
    private Canvas canvas;
    private KeyHandler keyHandler;
    private static String username;

    public Player(Canvas canvas, KeyHandler keyHandler) {
        this.canvas = canvas;
        this.keyHandler = keyHandler;
        setDefaultValues();
        try {
            getPlayerImage();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void setUsername(String username) {
        Player.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 3;
        direction = "up";
    }

    public void getPlayerImage() throws IOException {
        up1 = new Image(TempleRunApp.class.getResource("img/north_1.png").toExternalForm());
        up2 = new Image(TempleRunApp.class.getResource("img/north_2.png").toExternalForm());
        down1 = new Image(TempleRunApp.class.getResource("img/south_1.png").toExternalForm());
        down2 = new Image(TempleRunApp.class.getResource("img/south_2.png").toExternalForm());
        left1 = new Image(TempleRunApp.class.getResource("img/west_1.png").toExternalForm());
        left2 = new Image(TempleRunApp.class.getResource("img/west_2.png").toExternalForm());
        right1 = new Image(TempleRunApp.class.getResource("img/east_1.png").toExternalForm());
        right2 = new Image(TempleRunApp.class.getResource("img/east_2.png").toExternalForm());

    }

    public void update() {
        if (keyHandler.isUpPressed() == true) {
            direction = "up";
            y -= speed;
        } else if (keyHandler.isDownPressed() == true) {
            direction = "down";
            y += speed;
        } else if (keyHandler.isLeftPressed() == true) {
            direction = "left";
            x -= speed;
        } else if (keyHandler.isRightPressed() == true) {
            direction = "right";
            x += speed;
        }

        spriteCounter++;
        if (spriteCounter > 12) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }

    public void draw(GraphicsContext g2) {
        Image image = null;

        switch (direction) {

            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (this.spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (this.spriteNum == 1) {
                    image = down1;
                }
                if (this.spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (this.spriteNum == 1) {
                    image = left1;
                }
                if (this.spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (this.spriteNum == 1) {
                    image = right1;
                }
                if (this.spriteNum == 2) {
                    image = right2;
                }
                break;

        }

        g2.drawImage(image, x, y, Settings.tileSize, Settings.tileSize);

    }

}
