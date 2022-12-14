package de.tilmanschweitzer.adventofcode.puzzle.aoc2016.day08.command;

import de.tilmanschweitzer.adventofcode.puzzle.aoc2016.day08.command.CreateRectCommand;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2016.day08.command.parser.CreateRectCommandParser;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2016.day08.screen.DefaultScreenFactory;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2016.day08.screen.Screen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreateRectCommandTest {

    @Test
    void parse() {
        assertEquals(new CreateRectCommand(7, 13), new CreateRectCommandParser().parse("rect 7x13"));
        assertEquals(new CreateRectCommand(17, 5), new CreateRectCommandParser().parse("rect 17x5"));
    }

    @Test
    void apply() {
        final Screen screen = new DefaultScreenFactory().create(7, 3);
        final String expectedString = "###....\n" +
                "###....\n" +
                ".......";

        new CreateRectCommand(3, 2).apply(screen);

        assertEquals(expectedString, screen.toString());
    }

}
