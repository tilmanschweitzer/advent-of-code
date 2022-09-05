package de.tilmanschweitzer.adventofcode.puzzle.aoc2018;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

class Day02Test {

    @Test
    void getResultOfFirstPuzzle() {
        assertEquals(6474L, new Day02().getResultOfFirstPuzzle());
    }

    @Test
    void getResultOfSecondPuzzle() {
        assertEquals(0L, new Day02().getResultOfSecondPuzzle());
    }

    @Test
    void countNumberOfLettersByOccurence() {
        assertEquals(0, Day02.countNumberOfLettersByOccurrence("abcdef", 2));
        assertEquals(6, Day02.countNumberOfLettersByOccurrence("abcdef", 1));
        assertEquals(1, Day02.countNumberOfLettersByOccurrence("bababc", 2));
        assertEquals(1, Day02.countNumberOfLettersByOccurrence("bababc", 3));
    }


    @Test
    void countNumberOfLettersThatOccurTwiceInList() {
        final List<String> list = List.of("abcdef",
                "bababc",
                "abbcde",
                "abcccd",
                "aabcdd",
                "abcdee",
                "ababab");
        assertEquals(4, Day02.countNumberOfLinesWithLettersMatchingTheOccurrence(list, 2));
        assertEquals(3, Day02.countNumberOfLinesWithLettersMatchingTheOccurrence(list, 3));
    }

}
