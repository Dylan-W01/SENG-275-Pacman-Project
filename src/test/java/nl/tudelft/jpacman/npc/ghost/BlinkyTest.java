package nl.tudelft.jpacman.npc.ghost;

import nl.tudelft.jpacman.board.*;
import nl.tudelft.jpacman.level.LevelFactory;
import nl.tudelft.jpacman.level.MapParser;
import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


import java.io.InputStream;

import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.util.List;

class BlinkyTest {
    //set up map with player and ghost



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
//        parser = new MapParser(levelFactory, new BoardFactory(sprites));
        parser = new GhostMapParser(levelFactory, new BoardFactory(sprites), new GhostFactory(sprites));
    }

    @Test
    void testGhostOnMap() {
        try (InputStream i = getClass().getResourceAsStream("/blinkytestboard.txt")) {
            Board b = parser.parseMap(i).getBoard();
            Square s1 = b.squareAt(1, 1);
            Square[][] board = new Square[1][1];
//            grid[x][y] = makeGhostSquare(ghosts, ghostFactory.createClyde());
//            parser.addSquare(board, new ArrayList<>(), new ArrayList<>(), 4, 3, 'B');
            Unit unit = Navigation.findNearest(Ghost.class, s1);
            assertThat(unit).isNotNull();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
        // test if horizontal distance (between G and P) is less, G moves
        // Given ghost G and player P are on a map
        // When horizontal distance between G and P is less than vertical distance between them
        // then G moves towards P horizontally
        // Given ghost G and player P are on a map
        // When vertical  distance between G and P is less than horizontal distance between them
        // then G moves towards P vertically

        //if player starts at (1, 1) and ghost starts at (4, 2), ghost moves NORTH (closes shortest gap), then moves WEST (glosest next shortest gap)
    void testnextAiMove() {


        try (InputStream i = getClass().getResourceAsStream("/blinkytestboard.txt")) {
            Board b = parser.parseMap(i).getBoard();
            Square sqr_from = b.squareAt(4, 2);
            Square sqr_to = b.squareAt(1, 1);
            List<Direction> path = Navigation
                    .shortestPath(sqr_from, sqr_to, mock(Unit.class));
            assertThat(path).containsExactly(Direction.NORTH, Direction.WEST, Direction.WEST, Direction.WEST);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    /*
    * Testing order of priority for directions:
    * 1. Up
    * 2. Left
    * 3. Down
    * 4. Right
    * */
    @Test
    void testnextAiMove2() {


        try (InputStream i = getClass().getResourceAsStream("/blinkytestboard2.txt")) {
            Board b = parser.parseMap(i).getBoard();
            Square sqr_from = b.squareAt(2, 2);
            Square sqr_to = b.squareAt(1, 1);
            List<Direction> path = Navigation
                    .shortestPath(sqr_from, sqr_to, mock(Unit.class));
            assertThat(path).containsExactly(Direction.NORTH, Direction.WEST);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}