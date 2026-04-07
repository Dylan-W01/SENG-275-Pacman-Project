package nl.tudelft.jpacman.npc.ghost;

import nl.tudelft.jpacman.board.Board;
import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.board.Unit;
import nl.tudelft.jpacman.game.GameFactory;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.LevelFactory;
import nl.tudelft.jpacman.level.MapParser;
import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


import nl.tudelft.jpacman.npc.ghost.GhostMapParser;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import java.io.InputStream;
import java.io.IOException;

class BlinkyTest {
    //set up map with player and ghost

    // test if horizontal distance (between G and P) is greater, G moves
    // Given ghost G and player P are on a map
    // When horizontal distance between G and P is greater than vertical distance between them
    // then G moves towards P horizontally

    private MapParser parser;

    /**
     * Set up the map parser.
     */
    @BeforeEach
    void setUp() {
        PacManSprites sprites = new PacManSprites();
        LevelFactory levelFactory = new LevelFactory(
                sprites,
                new GhostFactory(sprites),
                mock(PointCalculator.class));
        parser = new MapParser(levelFactory, new BoardFactory(sprites));
    }

    @Test
    void testAiMoveHorizontal() {
        try (InputStream i = getClass().getResourceAsStream("testboard.txt")) {
            Board b = parser.parseMap(i).getBoard();
            Square s1 = b.squareAt(1, 1);
            Unit unit = Navigation.findNearest(Ghost.class, s1);
            assertThat(unit).isNotNull();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        GhostMapParser();
//        GameFactory gf = getGameFactory();
//        Level level = makeLevel();
//        Game game = gf.createSinglePlayerGame(level, loadPointCalculator());
//        return game;

    }



    //Given ghost G and player P are on a map
    // when vertical distance between G and P is greater than horizontal distance
    // then G moves towards P vertically
}