package templeRun.entity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import templeRun.Score;
import templeRun.Settings;
import templeRun.TempleRun;
import templeRun.TempleRunApp;
import templeRun.io.KeyHandler;
import templeRun.io.SaveAndLoad;

public class Player extends Entity {
    private static Player player = null;
    private TempleRun tr;
    private KeyHandler keyHandler;
    private String username;
    public final int screenX;
    public final int screenY;
    private Long points;
    private int difficultyTimer;
    private int horisontalSpeed;

    private Player() {
        setDefaultValues();
        try {
            getPlayerImage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        screenX = Settings.screenWith / 2 - (Settings.tileSize / 2);
        screenY = Settings.screenHeight / 2 - (Settings.tileSize / 2);

        soliedSpace = new Rectangle2D(16, 24, 10, 8);
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
        horisontalSpeed = 3;
        direction = "up";
        points = 0L;
        difficultyTimer = 0;
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
            direction = "left";
            worldY -= speed;
            worldX -= horisontalSpeed;
        } else if ((keyHandler.isUpPressed() && keyHandler.isRightPressed()) == true) {
            direction = "right";
            worldY -= speed;
            worldX += horisontalSpeed;
        } else if ((keyHandler.isDownPressed() && keyHandler.isLeftPressed()) == true) {
            direction = "up";
            worldY += speed;
            worldX -= horisontalSpeed;
        } else if ((keyHandler.isDownPressed() && keyHandler.isRightPressed()) == true) {
            direction = "up";
            worldY += speed;
            worldX += horisontalSpeed;
        } else if (keyHandler.isUpPressed() == true) {
            direction = "up";
            worldY -= speed;
        } else if (keyHandler.isDownPressed() == true) {
            direction = "down";
            worldY += speed;
        } else if (keyHandler.isLeftPressed() == true) {
            direction = "left";
            worldX -= horisontalSpeed;
        } else if (keyHandler.isRightPressed() == true) {
            direction = "right";
            worldX += horisontalSpeed;
        }

        tr.colisionTester.checkTile(this);
        if (collisionOn == true) {
            gameOver();
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
            horisontalSpeed = 4;
        } else if (difficultyTimer > 8000) {
            speed = 9;
            horisontalSpeed = 6;
        }

        points++;
        difficultyTimer++;
    }

    private void gameOver() {
        tr.setGameOver();
        Score playerdata = new Score(username, points);
        SaveAndLoad saveplayer = new SaveAndLoad();
        try {
            HashMap<String, Score> tmp = new HashMap<String, Score>(saveplayer.readSavedScoreboard());
            if (tmp.containsKey(username)) {
                if (tmp.get(username).getPoints() < points) {
                    tmp.put(username, playerdata);
                }
            } else {
                tmp.put(username, playerdata);
            }
            saveplayer.saveStats(tmp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        player.setDefaultValues();
        tr.switchController(playerdata);
        collisionOn = false;
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
