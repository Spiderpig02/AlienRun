package templeRun;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;

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
        
    }
}
