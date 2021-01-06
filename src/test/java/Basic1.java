import org.assertj.Crew;
import org.assertj.Rank;
import org.assertj.Ship;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.List;

import static org.assertj.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;

public class Basic1 {

    private Ship ship;
    private List<Crew> crew;

    @BeforeEach
    public void setUp() {
        crew = List.of(new Crew("James T. Kirk", CAPTAIN), new Crew("Spock", COMMANDER));
        ship = new Ship("USS Enterprise", "NCC-1701", null,  crew);
    }


    @Test
    public void testThrowing() {
        if (!ship.name().equals("USS Enterprise")) {
            throw new AssertionError("Incorrect name");
        }
        if (!ship.crew().get(0).rank().equals(CAPTAIN)) {
            throw new AssertionError("Should be CAPTAIN");
        }
        if (!ship.crew().get(1).rank().equals(COMMANDER)) {
            throw new AssertionError("Should be COMMANDER");
        }
    }

    @Test
    public void testAssert() {
        assert ship.name().equals("USS Enterprise");
        assert ship.crew().get(0).rank().equals(CAPTAIN);
    }

    @Test
    public void testJunit() {
        Assertions.assertEquals("USS Enterprise", ship.name());
        Assertions.assertIterableEquals(crew, ship.crew());
    }

    @Test
    public void testHamcrest() {
        MatcherAssert.assertThat(ship.name(), CoreMatchers.equalTo("USS Enterprise"));
        MatcherAssert.assertThat(ship.crew(), Matchers.hasItem(new Crew("Spock", COMMANDER)));

    }

    @Test
    public void testAssertJ() {
        assertThat(ship).extracting(Ship::name).isEqualTo("USS Enterprise");
        assertThat(ship.crew())
                .extracting(Crew::rank)
                .containsExactly(CAPTAIN, COMMANDER);
    }
}
