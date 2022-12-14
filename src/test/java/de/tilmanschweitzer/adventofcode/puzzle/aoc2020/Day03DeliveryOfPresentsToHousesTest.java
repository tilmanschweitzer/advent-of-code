package de.tilmanschweitzer.adventofcode.puzzle.aoc2020;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

import de.tilmanschweitzer.adventofcode.puzzle.aoc2020.Day03;

class Day03DeliveryOfPresentsToHousesTest {

    @Test
    void getResultOfFirstPuzzle() {
        assertEquals(156L, new Day03().getResultOfFirstPuzzle());
    }

    @Test
    void getResultOfSecondPuzzle() {
        assertEquals(3521829480L, new Day03().getResultOfSecondPuzzle());
    }

    @Test
    void parseLine_parsesTestInputAsExpected() {
        final String testInput = "..##.......\n" +
                "#...#...#..\n" +
                ".#....#..#.\n" +
                "..#.#...#.#\n" +
                ".#...##..#.\n" +
                "..#.##.....\n" +
                ".#.#.#....#\n" +
                ".#........#\n" +
                "#.##...#...\n" +
                "#...##....#\n" +
                ".#..#...#.#";


        final Day03 day03 = new Day03();
        final long result = day03.getResultOfFirstPuzzle(Arrays.stream(testInput.split("\n")).map(day03::parseLine).collect(Collectors.toList()));

        assertEquals(7, result);
    }
}
