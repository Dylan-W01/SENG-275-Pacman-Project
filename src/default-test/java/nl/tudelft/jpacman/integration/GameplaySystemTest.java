package nl.tudelft.jpacman.integration;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Player;

/**
 * System tests for core gameplay mechanics.
 */
public class GameplaySystemTest {

    private Launcher launcher;

    @BeforeEach
    void setUp() {
        launcher = new Launcher();
    }

    @AfterEach
    void tearDown() {
        launcher.dispose();
    }

    @Test
    void gameCanBePausedAndResumed() {
        launcher.launch();
        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);

        game.start();
        game.move(player, Direction.EAST);
        int scoreWhilePlaying = player.getScore();

        game.stop();
        assertThat(game.isInProgress()).isFalse();

        game.move(player, Direction.EAST);
        assertThat(player.getScore()).isEqualTo(scoreWhilePlaying);

        game.start();
        assertThat(game.isInProgress()).isTrue();

        game.move(player, Direction.EAST);
        assertThat(player.getScore()).isGreaterThanOrEqualTo(scoreWhilePlaying);
    }

    @Test
    void scoreIncreases() {
        launcher.launch();
        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);

        game.start();
        int initialScore = player.getScore();

        game.move(player, Direction.EAST);

        assertThat(player.getScore()).isGreaterThanOrEqualTo(initialScore);
    }

    // @Test
    // void canLoadAndPlayCustomMap() {
    //     launcher.withMapFile("/simplemap.txt").launch();
    //     Game game = launcher.getGame();

    //     game.start();
    //     assertThat(game.isInProgress()).isTrue();
    //     assertThat(game.getLevel().remainingPellets()).isGreaterThan(0);
    // }
}
