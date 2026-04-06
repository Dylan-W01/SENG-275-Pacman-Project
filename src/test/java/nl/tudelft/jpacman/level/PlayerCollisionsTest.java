package nl.tudelft.jpacman.level;
import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.points.PointCalculator;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class PlayerCollisionsTest {

    @Test
    void testPlayerVersusGhost() {
        PointCalculator calculator = mock(PointCalculator.class);
        PlayerCollisions collisions = new PlayerCollisions(calculator);

        Player player = mock(Player.class);
        Ghost ghost = mock(Ghost.class);

        collisions.playerVersusGhost(player, ghost);

        verify(calculator).collidedWithAGhost(player, ghost);
        verify(player).setAlive(false);
        verify(player).setKiller(ghost);
    }

    @Test
    void testPlayerVersusPellet() {
        PointCalculator calculator = mock(PointCalculator.class);
        PlayerCollisions collisions = new PlayerCollisions(calculator);

        Player player = mock(Player.class);
        Pellet pellet = mock(Pellet.class);

        collisions.playerVersusPellet(player, pellet);

        verify(calculator).consumedAPellet(player, pellet);
        verify(pellet).leaveSquare();
    }

    @Test
    void testPlayerCollidesWithGhost() {
        PointCalculator calculator = mock(PointCalculator.class);
        PlayerCollisions collisions = new PlayerCollisions(calculator);

        Player player = mock(Player.class);
        Ghost ghost = mock(Ghost.class);

        collisions.playerVersusGhost(player, ghost);

        verify(calculator).collidedWithAGhost(player, ghost);
    }

    @Test
    void testGhostCollidesWithPlayer() {
        PointCalculator calculator = mock(PointCalculator.class);
        PlayerCollisions collisions = new PlayerCollisions(calculator);

        Player player = mock(Player.class);
        Ghost ghost = mock(Ghost.class);

        collisions.collide(ghost, player);

        verify(calculator).collidedWithAGhost(player, ghost);
    }
}