package nl.tudelft.jpacman.game;

import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Pellet;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.sprite.AnimatedSprite;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class SinglePlayerGameTest {
    private SinglePlayerGame game;
    private Player player;
    private Level level;

    @BeforeEach
    void setUp() {
        level = mock(Level.class);
        AnimatedSprite deathSprite = mock(AnimatedSprite.class);
        player = new Player(Map.of(), deathSprite) {};

        PointCalculator pointCalculator = new PointCalculator() {
            @Override
            public void collidedWithAGhost(Player player, Ghost ghost) {
                // do nothing
            }

            @Override
            public void consumedAPellet(Player player, Pellet pellet) {

            }

            @Override
            public void pacmanMoved(Player player, Direction direction) {

            }
        };

        game = new SinglePlayerGame(player, level, pointCalculator);
    }

    @Test
    void testGetPlayers() {
        List<Player> players = game.getPlayers();
        assertEquals(1, players.size());
        assertEquals(player, players.get(0));
    }

    @Test
    void testGetLevel() {
        assertEquals(level, game.getLevel());
    }

}
