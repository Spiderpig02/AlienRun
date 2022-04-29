package templeRun;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import templeRun.entity.Player;

public class PlayerTest {

    private Player player1;
    private Player player2;
    private Player player3;

    @BeforeEach
    public void setup() {
        player1 = Player.getInstence();
        player2 = Player.getInstence();
        player3 = Player.getInstence();
        player1.setSpeed(3);
    }

    @Test
    @DisplayName("Testing the Player class for Singleton")
    public void playerClassTest() {
        assertEquals(player1, player2);
        assertEquals(player1, player3);
        player2.setSpeed(53);
        player1.setSpeed(23);
        assertEquals(player1, player2);
        assertEquals(player1, player3);

    }

    @Test
    @DisplayName("Testing player speed and direction")
    public void speedAndDirection() {
        assertEquals(3, player1.getSpeed());
        assertEquals(player1.getDirection(), player2.getDirection());

    }

}
