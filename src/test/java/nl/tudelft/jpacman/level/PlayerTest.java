package nl.tudelft.jpacman.level;

import org.junit.jupiter.api.Test;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.level.PlayerFactory;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.BeforeEach;

import org.mockito.Mockito;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.sprite.AnimatedSprite;
import nl.tudelft.jpacman.sprite.Sprite;
import java.util.Map;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player player;

    @BeforeEach
    void setup() {
        Map<Direction, Sprite> sprites = Mockito.mock(Map.class);
        AnimatedSprite deathSprite = Mockito.mock(AnimatedSprite.class);
        player = new Player(sprites, deathSprite);
    }


    @Test
    void isAlive() {
    }

    @Test
    void playerStartsAlive(){
        assertThat(player.isAlive()).isTrue();
    }

    @Test
    void playerStartsWith0score(){
        assertThat(player.getScore()).isEqualTo(0);
    }

    @Test
    void playerGetsPoints(){
        player.addPoints(10);
        assertThat(player.getScore()).isEqualTo(10);
    }

    @Test
    void playerDies(){
        player.setAlive(false);
        assertThat(player.isAlive()).isFalse();
    }

}