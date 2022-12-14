package de.tilmanschweitzer.adventofcode.puzzle.aoc2017;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

import de.tilmanschweitzer.adventofcode.puzzle.aoc2017.Day06;

class Day06Test {

    @Test
    void getResultOfFirstPuzzle() {
        assertEquals(11137, new Day06().getResultOfFirstPuzzle());
    }

    @Test
    void getResultOfSecondPuzzle() {
        assertEquals(1037, new Day06().getResultOfSecondPuzzle());
    }

    @Test
    void findCombinationsUntilInfiniteLoopIsDetected() {
        final Set<List<Integer>> expectedResult = Set.of(
                List.of(0, 2, 7, 0),
                List.of(2, 4, 1, 2),
                List.of(3, 1, 2, 3),
                List.of(0, 2, 3, 4),
                List.of(1, 3, 4, 1)
        );

        assertEquals(expectedResult, Day06.MemoryBlocks.from(List.of(0, 2, 7, 0)).findCombinationsUntilInfiniteLoopIsDetected());
    }

    @Test
    void findNumberOfCyclesInInfinite() {
        assertEquals(4, Day06.MemoryBlocks.from(List.of(0, 2, 7, 0)).findNumberOfCyclesInInfinite());
    }
}
