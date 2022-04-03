package templeRun.entity;

import java.io.IOException;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import templeRun.Settings;
import templeRun.io.KeyHandler;

public class Player extends Entity {
    Canvas canvas;
    KeyHandler keyHandler;

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

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 3;
        direction = "up";
    }

    public void getPlayerImage() throws IOException {
        up1 = new Image(getClass().getResourceAsStream("img/north_1.png"));
        up2 = new Image(getClass().getResourceAsStream("img/north_2.png"));
        down1 = new Image(getClass().getResourceAsStream("img/south_1.png"));
        down2 = new Image(getClass().getResourceAsStream("img/south_2.png"));
        left1 = new Image(getClass().getResourceAsStream("img/west_1.png"));
        left2 = new Image(getClass().getResourceAsStream("img/west_2.png"));
        right1 = new Image(getClass().getResourceAsStream("img/east_1.png"));
        right2 = new Image(getClass().getResourceAsStream("img/east_2.png"));
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
    }

    public void draw(GraphicsContext g2) {
        Image image = up1;

        g2.drawImage(image, x, y, Settings.tileSize, Settings.tileSize);

    }

}
