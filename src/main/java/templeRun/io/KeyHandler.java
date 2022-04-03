package templeRun.io;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyHandler {

    private boolean upPressed, downPressed, leftPressed, rightPressed;

    public void keyPressed(KeyEvent e) {

        if (e.getCode() == KeyCode.W) {
            this.upPressed = true;
        }
        if (e.getCode() == KeyCode.A) {
            this.leftPressed = true;
        }
        if (e.getCode() == KeyCode.S) {
            this.downPressed = true;
        }
        if (e.getCode() == KeyCode.D) {
            this.rightPressed = true;
        }
        if (e.getCode() == KeyCode.KP_UP) {
            this.upPressed = true;
        }
        if (e.getCode() == KeyCode.KP_LEFT) {
            this.leftPressed = true;
        }
        if (e.getCode() == KeyCode.KP_DOWN) {
            this.downPressed = true;
        }
        if (e.getCode() == KeyCode.KP_RIGHT) {
            this.rightPressed = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getCode() == KeyCode.W) {
            this.upPressed = false;
        }
        if (e.getCode() == KeyCode.A) {
            this.leftPressed = false;
        }
        if (e.getCode() == KeyCode.S) {
            this.downPressed = false;
        }
        if (e.getCode() == KeyCode.D) {
            this.rightPressed = false;
        }
        if (e.getCode() == KeyCode.KP_UP) {
            this.upPressed = false;
        }
        if (e.getCode() == KeyCode.KP_LEFT) {
            this.leftPressed = false;
        }
        if (e.getCode() == KeyCode.KP_DOWN) {
            this.downPressed = false;
        }
        if (e.getCode() == KeyCode.KP_RIGHT) {
            this.rightPressed = false;
        }
    }

}
