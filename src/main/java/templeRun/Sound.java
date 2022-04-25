package templeRun;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Sound {

    private Media mediaList[] = new Media[4];
    private MediaPlayer player;

    public Sound() {
        mediaList[0] = new Media(getClass().getResource("/sound/GameSound.mp3").toExternalForm());
        mediaList[1] = new Media(getClass().getResource("/sound/GameOver.mp3").toExternalForm());
        mediaList[2] = new Media(getClass().getResource("/sound/SpeedIncrees.mp3").toExternalForm());

    }

    public void setFile(int sound) {
        player = new MediaPlayer(mediaList[sound]);
    }

    public void play() {
        player.play();
    }

    public void loop() {

    }

    public void stop() {
        player.stop();
    }
}
