package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import net.jqwik.api.*;
import net.jqwik.api.arbitraries.*;

/**
 * A very simple (and not particularly useful)
 * test class to have a starting point where to put tests.
 *
 * @author Arie van Deursen
 */
public class DirectionTest {
    /**
     * Do we get the correct delta when moving north?
     */
    @Test
    void testNorth() {
        Direction north = Direction.valueOf("NORTH");
        assertThat(north.getDeltaY()).isEqualTo(-1);
    }

    @Provide
    public Arbitrary<Direction> directions(){
        return Arbitraries.of(Direction.values());
    }
    @Property
    void directions_X(@ForAll("directions") Direction dir){
        assertThat(dir.getDeltaX()).isBetween(-1,1);
    }
}
