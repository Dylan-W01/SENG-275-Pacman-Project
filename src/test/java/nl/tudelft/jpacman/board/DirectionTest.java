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
    @Property
    void directions_Y(@ForAll("directions") Direction dir){
        assertThat(dir.getDeltaY()).isBetween(-1,1);
    }


        @Property
        void no_diagonal(@ForAll("directions") Direction dir ){
            int dir_x = dir.getDeltaX();
            int dir_y = dir.getDeltaY();
            assertThat((dir_x == 0) ^ (dir_y == 0)).isTrue();
    }

    @Provide
    Arbitrary<Direction[]> opposites() {
        return Arbitraries.of(
                new Direction[]{Direction.NORTH, Direction.SOUTH},
                new Direction[]{Direction.SOUTH, Direction.NORTH},
                new Direction[]{Direction.EAST, Direction.WEST},
                new Direction[]{Direction.WEST, Direction.EAST}
        );
    }

    @Property
    void cancel_out(@ForAll("opposites") Direction[] pair){
    assertThat(pair[0].getDeltaY() + pair[1].getDeltaY()).isEqualTo(0);
    assertThat(pair[1].getDeltaY() + pair[0].getDeltaY()).isEqualTo(0);

    }







}
