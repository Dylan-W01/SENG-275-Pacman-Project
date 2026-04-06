package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.board.BoardFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import nl.tudelft.jpacman.level.MapParser;
import org.mockito.Mockito;
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
        char[][] map = new char[0][0];//should be a list of chars to make a wall
//        mock(LevelFactory);
//        MapParser(mock(LevelFactory.class), mock(BoardFactory.class).parseMap(map);
        MapParser mockMapParser = mock(MapParser.class);

        Level mockLevel = mockMapParser.parseMap(map);
        //verifying that parseMap() has been called
        verify(mockMapParser).parseMap(map);


//        when(mockMapParser.parseMap())
//        verify(MapParser.parseMap());

    }

}