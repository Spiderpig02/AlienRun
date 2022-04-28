package templeRun;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import templeRun.entity.Player;
import templeRun.main.ColisionTester;
import templeRun.main.TempleRun;

public class ColisionTesterTest {

    private static ColisionTester tester;
    private static TempleRun tr = new TempleRun();
    private static Player player = Player.getInstence();

    @BeforeAll
    public static void setup() {
        tester = new ColisionTester(tr);
    }

    @Test
    @DisplayName("Testing that the player does not colied with anything at the star")
    public void playerNotColied() {
        assertFalse(player.isCollisionOn());
        tester.checkTile(player);
        assertFalse(player.isCollisionOn());
    }
}
