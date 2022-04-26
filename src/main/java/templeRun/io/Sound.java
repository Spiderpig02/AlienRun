package templeRun.io;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import templeRun.main.TempleRun;

public class Sound {

    private Media mediaList[] = new Media[4];
    private MediaPlayer player;

    public Sound() {
        mediaList[0] = new Media(TempleRun.class.getResource("sound/GameSound.mp3").toExternalForm());
        mediaList[1] = new Media(TempleRun.class.getResource("sound/SpeedIncrees.mp3").toExternalForm());
        mediaList[2] = new Media(TempleRun.class.getResource("sound/GameOver.mp3").toExternalForm());
    }

    public void setFile(int sound) {
        if (sound >= 0 && sound < 4) {
            player = new MediaPlayer(mediaList[sound]);
            if (sound == 0) {
                player.setCycleCount(10);
            }
        }
    }

    public void play() {
        player.play();
    }

    public void stop() {
        player.stop();
    }
}
