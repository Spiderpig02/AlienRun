package templeRun;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import templeRun.entity.Score;

public class ScoreTest {

    private Score score1;
    private Score score2;
    private Score score3;

    @BeforeEach
    public void setup() {
        score1 = new Score("Jens", 420L);
        score2 = new Score("Martin", 69L);
        score3 = new Score("Herman", 1337L);
    }

    @Test
    @DisplayName("Testing if the constructers validation is working")
    public void testScore() {
        Score test1 = new Score("Test1", -14243L);
        assertEquals(0L, test1.getPoints());
        assertThrows(IllegalArgumentException.class, () -> {
            Score test2 = new Score("", 0L);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Score test2 = new Score("          ", 0L);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Score test2 = new Score("#($/))#($/#)#(:;_§", 0L);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Score test2 = new Score("Spiller 1 med mellomrom", 0L);
        });
    }

    @Test
    @DisplayName("A test for the Comparable implementation")
    public void testCompareTo() {
        List<Score> list = new ArrayList<>(List.of(score1, score2, score3));
        List<Score> correctList = new ArrayList<>(List.of(score3, score1, score2));
        assertNotEquals(list, correctList);
        Collections.sort(list);
        assertEquals(correctList, list);

    }
}
