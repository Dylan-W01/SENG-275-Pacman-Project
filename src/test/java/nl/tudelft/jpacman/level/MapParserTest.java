package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.board.Board;
import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.npc.Ghost;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import nl.tudelft.jpacman.level.MapParser;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;


class MapParserTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    // Produce a map comprised of just one wall using Mockito
    @Test
    void testParseMap() {
        int height = 10;
        int width = 10;
        char[][] map = new char[width][height];//should be a list of chars to make a wall
        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                map[x][y] = ' ';
            }
        }
        map[4][4] = '#';

//        mock(LevelFactory);
//        MapParser(mock(LevelFactory.class), mock(BoardFactory.class).parseMap(map);
        LevelFactory levelCreatorMock = mock(LevelFactory.class);
        BoardFactory boardCreatorMock = mock(BoardFactory.class);

        MapParser mockMapParser = mock(MapParser.class);
        MapParser mockMapParser2 = new MapParser(levelCreatorMock, boardCreatorMock);
        List<String> the_text = List.of("#");
        Level mockLevel = mockMapParser.parseMap(the_text);
        //verifying that parseMap() has been called
        //promote dummy to spy
//        verify(mockMapParser).parseMap(map);

        verify(mockMapParser).parseMap(the_text);
//        verify(mockMapParser2).parseMap(map);
        //promote to a stub
            //but this test does not create a map with a wall... it just checks to see that parseMap returns null...
        when(mockMapParser.parseMap(map)).thenReturn(null);

        /// stuck on this part; don't know how to proceed
        /**
        Level mockLevel2 = mockMapParser2.parseMap(the_text);
        Square[][] grid = new Square[1][1];
        Board board = boardCreatorMock.createBoard(grid);
        List<Ghost> ghosts = new ArrayList<>();
        List<Square> startPositions = new ArrayList<>();
        when(mockMapParser2.parseMap(map)).thenReturn(levelCreatorMock.createLevel(board, ghosts, startPositions));
         **/



//        Square[][] grid = new Square[width][height];
//        Board board = boardCreatorMock.createBoard(grid);
//        List<Ghost> ghosts = new ArrayList<>();
//        List<Square> startPositions = new ArrayList<>();
//        when(mockMapParser.parseMap(map)).thenReturn(levelCreatorMock.createLevel(board, ghosts, startPositions));
        //promote stub to a mock


//        when(mockMapParser.parseMap())
//        verify(MapParser.parseMap());

    }

}