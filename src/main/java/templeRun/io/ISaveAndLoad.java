package templeRun.io;

import java.util.HashMap;

import templeRun.entity.Score;

public interface ISaveAndLoad {

    void saveStats(HashMap<String, Score> scoreboard);

    HashMap<String, Score> readSavedScoreboard();

    int[][] loadMap();

}
