package templeRun.entity;

import java.io.IOException;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import templeRun.Settings;
import templeRun.TempleRun;
import templeRun.TempleRunApp;
import templeRun.io.KeyHandler;

public class Player extends Entity {
    private static Player player = null;
    private TempleRun tr;
    private KeyHandler keyHandler;
    private String username;
    public final int screenX;
    public final int screenY;
    private Long points = Long.parseLong("0");
    private int difficultyTimer;

    private Player() {
        setDefaultValues();
        try {
            getPlayerImage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        screenX = Settings.screenWith / 2 - (Settings.tileSize / 2);
        screenY = Settings.screenHeight / 2 - (Settings.tileSize / 2);

        soliedSpace = new Rectangle2D(16, 16, 16, 32);
    }

    public int getWorldX() {
        return worldX;
    }

    public int getWorldY() {
        return worldY;
    }

    public int getScreenY() {
        return screenY;
    }

    public int getScreenX() {
        return screenX;
    }

    public static Player getInstence() {
        if (player == null) {
            player = new Player();
        }
        return player;
    }

    public void setPlayerThings(TempleRun tr, KeyHandler keyHandler) {
        this.tr = tr;
        this.keyHandler = keyHandler;
    }

    public Long getPlayerPoints() {
        return this.points;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setDefaultValues() {
        worldX = Settings.tileSize * 8;
        worldY = Settings.tileSize * 10;
        speed = 3;
        direction = "up";
    }

    public void getPlayerImage() throws IOException {
        up1 = new Image(TempleRunApp.class.getResource("img/North_1.png").toExternalForm());
        up2 = new Image(TempleRunApp.class.getResource("img/North_2.png").toExternalForm());
        down1 = new Image(TempleRunApp.class.getResource("img/South_1.png").toExternalForm());
        down2 = new Image(TempleRunApp.class.getResource("img/South_2.png").toExternalForm());
        left1 = new Image(TempleRunApp.class.getResource("img/East_1.png").toExternalForm());
        left2 = new Image(TempleRunApp.class.getResource("img/East_2.png").toExternalForm());
        right1 = new Image(TempleRunApp.class.getResource("img/West_1.png").toExternalForm());
        right2 = new Image(TempleRunApp.class.getResource("img/West_2.png").toExternalForm());

    }

    public void update() {
        if ((keyHandler.isUpPressed() && keyHandler.isLeftPressed()) == true) {
            direction = "up";
            worldY -= speed;
            worldX -= speed;
        } else if ((keyHandler.isUpPressed() && keyHandler.isRightPressed()) == true) {
            direction = "up";
            worldY -= speed;
            worldX += speed;
        } else if ((keyHandler.isDownPressed() && keyHandler.isLeftPressed()) == true) {
            direction = "up";
            worldY += speed;
            worldX -= speed;
        } else if ((keyHandler.isDownPressed() && keyHandler.isRightPressed()) == true) {
            direction = "up";
            worldY += speed;
            worldX += speed;
        } else if (keyHandler.isUpPressed() == true) {
            direction = "up";
            worldY -= speed;
        } else if (keyHandler.isDownPressed() == true) {
            direction = "down";
            worldY += speed;
        } else if (keyHandler.isLeftPressed() == true) {
            direction = "left";
            worldX -= speed;
        } else if (keyHandler.isRightPressed() == true) {
            direction = "right";
            worldX += speed;
        }

        tr.colisionTester.checkTile(this);
        if (collisionOn == true) {
            System.out.println("du er død egt");
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

        if (difficultyTimer > 3000 && difficultyTimer < 5000) {
            speed = 5;
        } else if (difficultyTimer > 5000 && difficultyTimer < 8000) {
            speed = 7;
        } else if (difficultyTimer > 8000) {
            speed = 9;
        }

        points++;
        difficultyTimer++;
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

        g2.drawImage(image, screenX, screenY, Settings.tileSize, Settings.tileSize);

    }

    @Override
    public String toString() {
        return getUsername() + ":\t" + String.valueOf(getPlayerPoints());
    }

}
