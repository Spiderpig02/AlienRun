package templeRun.entity;

import java.util.HashMap;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import templeRun.TempleRunApp;
import templeRun.io.KeyHandler;
import templeRun.io.SaveAndLoad;
import templeRun.main.Settings;
import templeRun.main.TempleRun;

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
        screenX = Settings.screenWith / 2 - (Settings.tileSize / 2);
        screenY = Settings.screenHeight / 2 - (Settings.tileSize / 2);

        setSoliedSpace(new Rectangle2D(16, 24, 10, 8));
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
        VerifyClass.verifyUsername(username);
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    private void setDefaultValues() {
        setWorldX(Settings.tileSize * 8);
        setWorldY(Settings.tileSize * 10);
        setSpeed(3);
        horisontalSpeed = 3;
        setDirection("up");
        points = 0L;
        difficultyTimer = 0;
    }

    public void getPlayerImage() {
        setUp1(new Image(TempleRunApp.class.getResource("img/North_1.png").toExternalForm()));
        setUp2(new Image(TempleRunApp.class.getResource("img/North_2.png").toExternalForm()));
        setDown1(new Image(TempleRunApp.class.getResource("img/South_1.png").toExternalForm()));
        setDown2(new Image(TempleRunApp.class.getResource("img/South_2.png").toExternalForm()));
        setLeft1(new Image(TempleRunApp.class.getResource("img/East_1.png").toExternalForm()));
        setLeft2(new Image(TempleRunApp.class.getResource("img/East_2.png").toExternalForm()));
        setRight1(new Image(TempleRunApp.class.getResource("img/West_1.png").toExternalForm()));
        setRight2(new Image(TempleRunApp.class.getResource("img/West_2.png").toExternalForm()));
    }

    public void update() {
        playerKeyAction();

        tr.getColisionTester().checkTile(this);
        if (isCollisionOn() == true) {
            gameOver();
        }

        updateSprite();

        checkDifferculty();

        points++;
        difficultyTimer++;
    }

    private void updateSprite() {
        setSpriteCounter(getSpriteCounter() + 1);
        if (getSpriteCounter() > 12) {
            if (getSpriteNum() == 1) {
                setSpriteNum(2);
            } else if (getSpriteNum() == 2) {
                setSpriteNum(1);
            }
            setSpriteCounter(0);
        }
    }

    private void playerKeyAction() {
        if ((keyHandler.isUpPressed() && keyHandler.isLeftPressed()) == true) {
            setDirection("left");
            setWorldY(getWorldY() - getSpeed());
            setWorldX(getWorldX() - horisontalSpeed);
        } else if ((keyHandler.isUpPressed() && keyHandler.isRightPressed()) == true) {
            setDirection("right");
            setWorldY(getWorldY() - getSpeed());
            setWorldX(getWorldX() + horisontalSpeed);
        } else if ((keyHandler.isDownPressed() && keyHandler.isLeftPressed()) == true) {
            setDirection("up");
            setWorldY(getWorldY() + getSpeed());
            setWorldX(getWorldX() - horisontalSpeed);
        } else if ((keyHandler.isDownPressed() && keyHandler.isRightPressed()) == true) {
            setDirection("up");
            setWorldY(getWorldY() + getSpeed());
            setWorldX(getWorldX() + horisontalSpeed);
        } else if (keyHandler.isUpPressed() == true) {
            setDirection("up");
            setWorldY(getWorldY() - getSpeed());
        } else if (keyHandler.isDownPressed() == true) {
            setDirection("down");
            setWorldY(getWorldY() + getSpeed());
        } else if (keyHandler.isLeftPressed() == true) {
            setDirection("left");
            setWorldX(getWorldX() - horisontalSpeed);
        } else if (keyHandler.isRightPressed() == true) {
            setDirection("right");
            setWorldX(getWorldX() + horisontalSpeed);
        }
    }

    private void checkDifferculty() {
        if (difficultyTimer > 3000 && difficultyTimer < 5000) {
            setSpeed(5);
            tr.speedIncrees();
        } else if (difficultyTimer > 5000 && difficultyTimer < 8000) {
            setSpeed(7);
            horisontalSpeed = 4;
            tr.speedIncrees();
        } else if (difficultyTimer > 8000) {
            setSpeed(9);
            horisontalSpeed = 6;
            tr.speedIncrees();
        }
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
        setCollisionOn(false);
    }

    public void draw(GraphicsContext g2) {
        Image image = null;

        switch (getDirection()) {

            case "up":
                if (getSpriteNum() == 1) {
                    image = getUp1();
                } else if (getSpriteNum() == 2) {
                    image = getUp2();
                }
                break;
            case "down":
                if (getSpriteNum() == 1) {
                    image = getDown1();
                } else if (getSpriteNum() == 2) {
                    image = getDown2();
                }
                break;
            case "left":
                if (getSpriteNum() == 1) {
                    image = getLeft1();
                } else if (getSpriteNum() == 2) {
                    image = getLeft2();
                }
                break;
            case "right":
                if (getSpriteNum() == 1) {
                    image = getRight1();
                } else if (getSpriteNum() == 2) {
                    image = getRight2();
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
