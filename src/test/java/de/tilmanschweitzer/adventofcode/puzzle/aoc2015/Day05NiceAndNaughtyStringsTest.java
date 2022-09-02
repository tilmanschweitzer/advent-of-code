package de.tilmanschweitzer.adventofcode.puzzle.aoc2015;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.Day05NiceAndNaughtyStrings;

class Day05NiceAndNaughtyStringsTest {

    @Test
    void getResultOfFirstPuzzle() {
        assertEquals(236, new Day05NiceAndNaughtyStrings().getResultOfFirstPuzzle());
    }

    @Test
    void getResultOfSecondPuzzle() {
        assertEquals(51, new Day05NiceAndNaughtyStrings().getResultOfSecondPuzzle());
    }

    @Test
    void detectNiceStrings() {
        assertTrue(Day05NiceAndNaughtyStrings.isNiceString("ugknbfddgicrmopn"));
        assertTrue(Day05NiceAndNaughtyStrings.isNiceString("aaa"));
    }

    @Test
    void detectNaughtyStrings() {
        assertFalse(Day05NiceAndNaughtyStrings.isNiceString("jchzalrnumimnmhp"));
        assertFalse(Day05NiceAndNaughtyStrings.isNiceString("haegwjzuvuyypxyu"));
        assertFalse(Day05NiceAndNaughtyStrings.isNiceString("dvszwmarrgswjxmb"));
    }


    @Test
    void detectNiceStringsVersion2() {
        assertTrue(Day05NiceAndNaughtyStrings.isNiceStringVersion2("qjhvhtzxzqqjkmpb"));
        assertTrue(Day05NiceAndNaughtyStrings.isNiceStringVersion2("xxyxx"));
    }

    @Test
    void detectNaughtyStringsVersion2() {
        assertFalse(Day05NiceAndNaughtyStrings.isNiceStringVersion2("uurcxstgmygtbstg"));
        assertFalse(Day05NiceAndNaughtyStrings.isNiceStringVersion2("ieodomkazucvgmuy"));
    }
}
