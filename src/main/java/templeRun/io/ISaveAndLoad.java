package templeRun.io;

import java.io.IOException;
import java.util.HashMap;

public interface ISaveAndLoad {

    void saveStats(HashMap<String, Long> scoreboard) throws IOException;

    HashMap<String, Long> readSavedScoreboard() throws IOException;

}
