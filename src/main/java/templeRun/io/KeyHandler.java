package templeRun.io;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyHandler {

    private boolean upPressed, downPressed, leftPressed, rightPressed;

    public boolean isUpPressed() {
        return upPressed;
    }

    public boolean isDownPressed() {
        return downPressed;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public void keyPressed(KeyEvent e) {

        if (e.getCode() == KeyCode.W) {
            this.upPressed = true;
        } else if (e.getCode() == KeyCode.A) {
            this.leftPressed = true;
        } else if (e.getCode() == KeyCode.S) {
            this.downPressed = true;
        } else if (e.getCode() == KeyCode.D) {
            this.rightPressed = true;
        } else if (e.getCode() == KeyCode.UP) {
            this.upPressed = true;
            System.out.println("UP");
        } else if (e.getCode() == KeyCode.LEFT) {
            this.leftPressed = true;
        } else if (e.getCode() == KeyCode.DOWN) {
            this.downPressed = true;
        } else if (e.getCode() == KeyCode.RIGHT) {
            this.rightPressed = true;
        } else {
            System.out.println(e.getCode());
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getCode() == KeyCode.W) {
            this.upPressed = false;
        } else if (e.getCode() == KeyCode.A) {
            this.leftPressed = false;
        } else if (e.getCode() == KeyCode.S) {
            this.downPressed = false;
        } else if (e.getCode() == KeyCode.D) {
            this.rightPressed = false;
        } else if (e.getCode() == KeyCode.UP) {
            this.upPressed = false;
        } else if (e.getCode() == KeyCode.LEFT) {
            this.leftPressed = false;
        } else if (e.getCode() == KeyCode.DOWN) {
            this.downPressed = false;
        } else if (e.getCode() == KeyCode.RIGHT) {
            this.rightPressed = false;
        }
    }

}
