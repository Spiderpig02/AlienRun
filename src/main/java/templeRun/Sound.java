package templeRun;

import java.net.URL;

import javax.sound.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

    private Clip clip;
    private URL soundURL[] = new URL[4];

    public Sound() {
        soundURL[0] = getClass().getResource("/sound/GameSound.wav");
        soundURL[1] = getClass().getResource("/sound/GameOver.wav");
        soundURL[2] = getClass().getResource("/sound/SpeedIncrees.wav");

    }

    public void setFile(int sound) {

        try {
            AudioInputStream AudioInputStream = AudioSystem.getAudioInputStream(soundURL[sound]);
            clip = AudioSystem.getClip();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void play() {

    }

    public void loop() {

    }

    public void stop() {

    }
}
