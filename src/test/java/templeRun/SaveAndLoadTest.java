package templeRun;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.nio.file.Paths;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import templeRun.entity.Score;
import templeRun.io.SaveAndLoad;

public class SaveAndLoadTest {

    private SaveAndLoad SAL = new SaveAndLoad();
    private HashMap<String, Score> hashMap;
    private HashMap<String, Score> hashMap2;

    @BeforeEach
    public void setup() {
        hashMap = new HashMap<>();
        hashMap.put("Jens", new Score("Jens", 32L));
        hashMap.put("Jan", new Score("Jan", 3432L));
        hashMap.put("Johnny", new Score("Johnny", 362L));
        deleteFile();
    }

    private void deleteFile() {
        File scoreData = new File(Paths.get(".").toAbsolutePath().normalize().toString() + "/scoreData.txt");
        scoreData.delete();
    }

    @Test
    @DisplayName("Testing loading from an file that do not exist")
    public void fileNotCreatedYet() {
        HashMap<String, Score> emptyMap = new HashMap<>();
        assertDoesNotThrow(() -> {
            hashMap2 = SAL.readSavedScoreboard();
        });
        assertEquals(emptyMap, hashMap2);
    }

    @Test
    @DisplayName("Testing writing to a file and getting the same data back")
    public void saveDataTest() {
        HashMap<String, Score> tmp;
        assertDoesNotThrow(() -> {
            SAL.saveStats(hashMap);
        });
        tmp = SAL.readSavedScoreboard();
        tmp.forEach((e, f) -> {
            System.out.println(e + f);
            assertEquals(f.toString(), hashMap.get(e).toString());
        });
        hashMap.forEach((e, f) -> {
            System.out.println(e + f);
        });

        // assertEquals(hashMap, tmp);
    }
}
