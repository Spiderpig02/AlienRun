package templeRun.io;

import java.io.IOException;
import java.util.HashMap;

import templeRun.Score;

public interface ISaveAndLoad {

    void saveStats(HashMap<String, Score> scoreboard) throws IOException;

    HashMap<String, Score> readSavedScoreboard() throws IOException;

}
