package de.tilmanschweitzer.adventofcode.puzzle.aoc2016;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static de.tilmanschweitzer.adventofcode.common.Converters.stringToCharList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import de.tilmanschweitzer.adventofcode.puzzle.aoc2016.Day06;

class Day06Test {

    @Test
    void getResultOfFirstPuzzle() {
        assertEquals("mlncjgdg", new Day06().getResultOfFirstPuzzle());
    }

    @Test
    void getResultOfSecondPuzzle() {
        assertEquals("bipjaytb", new Day06().getResultOfSecondPuzzle());
    }

    final static List<String> testInput = List.of("eedadn",
            "drvtee",
            "eandsr",
            "raavrd",
            "atevrs",
            "tsrnev",
            "sdttsa",
            "rasrtv",
            "nssdts",
            "ntnada",
            "svetve",
            "tesnvt",
            "vntsnd",
            "vrdear",
            "dvrsen",
            "enarar");

    @Test
    void reconstructMessageByMostCommonChar() {
        assertEquals("easter", Day06.reconstructMessageByMostCommonChar(testInput));
    }

    @Test
    void reconstructMessageByLeastCommonChar() {
        assertEquals("advent", Day06.reconstructMessageByLeastCommonChar(testInput));
    }


    @Test
    void countChars() {
        final Map<Character, Long> expectedResult = Map.of('a', 3L, 'b', 2L, 'c', 1L, 'z', 2L, 'x', 1L);
        assertEquals(expectedResult, Day06.countChars(stringToCharList("aaabbczxz")));
    }

}
