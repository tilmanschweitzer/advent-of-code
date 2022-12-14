package de.tilmanschweitzer.adventofcode.puzzle.aoc2016.day08.command;

import de.tilmanschweitzer.adventofcode.puzzle.aoc2016.day08.command.RotateRowCommand;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2016.day08.command.parser.RotateRowCommandParser;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2016.day08.screen.DefaultScreenFactory;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2016.day08.screen.Screen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RotateRowCommandTest {

    @Test
    void parse() {
        assertEquals(new RotateRowCommand(13, 7), new RotateRowCommandParser().parse("rotate row y=13 by 7"));
        assertEquals(new RotateRowCommand(3, 17), new RotateRowCommandParser().parse("rotate row y=3 by 17"));
    }

    @Test
    void apply() {
        final Screen screen = new DefaultScreenFactory().create(7, 3);
        screen.turnOn(0, 1);

        final String expectedString = ".......\n" +
                "..#....\n" +
                ".......";

        new RotateRowCommand(1, 2).apply(screen);
        assertEquals(expectedString, screen.toString());

        new RotateRowCommand(1, 14).apply(screen);
        assertEquals(expectedString, screen.toString());
    }

}
