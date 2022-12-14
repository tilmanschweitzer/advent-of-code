package de.tilmanschweitzer.adventofcode.puzzle.aoc2016.day08.command;

import de.tilmanschweitzer.adventofcode.puzzle.aoc2016.day08.command.CreateRectCommand;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2016.day08.command.RotateColumnCommand;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2016.day08.command.RotateRowCommand;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2016.day08.command.parser.ChainedModifyScreenCommandParser;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2016.day08.command.parser.CreateRectCommandParser;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2016.day08.command.parser.RotateColumnCommandParser;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2016.day08.command.parser.RotateRowCommandParser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChainedModifyScreenCommandParserTest {

    @Test
    void parse() {
        final ChainedModifyScreenCommandParser universalParser = ChainedModifyScreenCommandParser.of(new CreateRectCommandParser(), new RotateRowCommandParser(), new RotateColumnCommandParser());

        assertEquals(new RotateColumnCommand(13, 7), universalParser.parse("rotate column x=13 by 7"));
        assertEquals(new RotateColumnCommand(3, 17), universalParser.parse("rotate column x=3 by 17"));
        assertEquals(new CreateRectCommand(7, 13), universalParser.parse("rect 7x13"));
        assertEquals(new CreateRectCommand(17, 5), universalParser.parse("rect 17x5"));
        assertEquals(new RotateRowCommand(13, 7), universalParser.parse("rotate row y=13 by 7"));
        assertEquals(new RotateRowCommand(3, 17), universalParser.parse("rotate row y=3 by 17"));
    }

}
