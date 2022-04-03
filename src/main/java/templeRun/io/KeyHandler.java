package templeRun.io;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyHandler implements EventHandler<KeyEvent> {

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

        if (e.getCode().equals(KeyCode.W)) {
            this.upPressed = true;
            System.out.println("W");
        }
        if (e.getCode() == KeyCode.A) {
            this.leftPressed = true;
            System.out.println("A");
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

    @Override
    public void handle(KeyEvent event) {
        // TODO Auto-generated method stub

    }

}
