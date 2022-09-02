package de.tilmanschweitzer.adventofcode.puzzle.aoc2016.day08;

import de.tilmanschweitzer.adventofcode.puzzle.aoc2016.day08.screen.DefaultScreenFactory;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2016.day08.screen.Screen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScreenTest {

    @Test
    void testToString() {
        final Screen screen = new DefaultScreenFactory().create(5, 4);
        final String expectedString = ".....\n" +
                ".....\n" +
                ".....\n" +
                ".....";

        assertEquals(expectedString, screen.toString());
    }

    @Test
    void turnOn() {
        final Screen screen = new DefaultScreenFactory().create(7, 3);
        screen.turnOn(5, 1);

        final String expectedString = ".......\n" +
                ".....#.\n" +
                ".......";

        assertEquals(expectedString, screen.toString());
    }
}
