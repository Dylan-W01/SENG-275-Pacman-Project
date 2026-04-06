package nl.tudelft.jpacman.level;

import org.junit.jupiter.api.Test;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.level.PlayerFactory;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player player;

    @BeforeEach
    void setup() {
        PacManSprites sprites = new PacManSprites();
        PlayerFactory factory = new PlayerFactory(sprites);
        player = factory.createPacMan();
    }


    @Test
    void isAlive() {
    }

    @Test
    void playerStartsAlive(){
        assertThat(player.isAlive()).isTrue();
    }
}