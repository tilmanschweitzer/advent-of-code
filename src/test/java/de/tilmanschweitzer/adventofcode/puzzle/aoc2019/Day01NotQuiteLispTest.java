package de.tilmanschweitzer.adventofcode.puzzle.aoc2019;

import org.junit.jupiter.api.Test;

import static de.tilmanschweitzer.adventofcode.puzzle.aoc2019.Day01.getFuelForMass;
import static de.tilmanschweitzer.adventofcode.puzzle.aoc2019.Day01.getTotalFuelForMass;
import static org.junit.jupiter.api.Assertions.assertEquals;

import de.tilmanschweitzer.adventofcode.puzzle.aoc2019.Day01;

class Day01NotQuiteLispTest {

    @Test
    void getResultOfFirstPuzzle() {
        assertEquals(3267890, new Day01().getResultOfFirstPuzzle());
    }

    @Test
    void getResultOfSecondPuzzle() {
        assertEquals(4898972, new Day01().getResultOfSecondPuzzle());
    }

    @Test
    void getFuelForMass_calculatesCorrectFules() {
        assertEquals(2, getFuelForMass(12));
        assertEquals(2, getFuelForMass(14));

        assertEquals(654, getFuelForMass(1969));
        assertEquals(33583, getFuelForMass(100756));
    }

    @Test
    void getTotalFuelForMass_calculatesCorrectFules() {
        assertEquals(2, getTotalFuelForMass(12));
        assertEquals(2, getFuelForMass(14));
        assertEquals(966, getTotalFuelForMass(1969));
        assertEquals(50346, getTotalFuelForMass(100756));
    }
}
