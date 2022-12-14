package de.tilmanschweitzer.adventofcode.puzzle.aoc2017;

import de.tilmanschweitzer.adventofcode.common.BasicCoordinate;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2017.Day03;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static de.tilmanschweitzer.adventofcode.common.BasicCoordinate.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day03Test {


    @Test
    void nextCoordinate() {
        assertEquals(of(1, 0), Day03.nextCoordinate(of(0, 0)));
        assertEquals(of(1, -1), Day03.nextCoordinate(of(1, 0)));
        assertEquals(of(0, -1), Day03.nextCoordinate(of(1, -1)));
        assertEquals(of(-1, -1), Day03.nextCoordinate(of(0, -1)));
        assertEquals(of(-1, 0), Day03.nextCoordinate(of(-1, -1)));
        assertEquals(of(-1, 1), Day03.nextCoordinate(of(-1, 0)));
        assertEquals(of(0, 1), Day03.nextCoordinate(of(-1, 1)));
        assertEquals(of(1, 1), Day03.nextCoordinate(of(0, 1)));

        // move to next level
        assertEquals(of(2, 1), Day03.nextCoordinate(of(1, 1)));
    }

    @Test
    void coordinatesForAddressSchema() {
        final List<BasicCoordinate> expectedResult = List.of(of(0, 0), of(1, 0), of(1, -1), of(0, -1), of(-1, -1));
        assertEquals(expectedResult, Day03.coordinatesForAddressSchema().limit(5).collect(Collectors.toList()));
    }


    @Test
    void getCoordinateForAccessPort() {
        assertEquals(of(1, 1), Day03.getCoordinateForAccessPort(9));
        assertEquals(of(2, 2), Day03.getCoordinateForAccessPort(25));
        assertEquals(of(3, 3), Day03.getCoordinateForAccessPort(49));
        assertEquals(of(4, 4), Day03.getCoordinateForAccessPort(81));
    }

    @Test
    void getManhattanDistanceForAccessPorts() {
        assertEquals(0, Day03.getManhattanDistanceForAccessPort(1));
        assertEquals(2, Day03.getManhattanDistanceForAccessPort(9));
        assertEquals(3, Day03.getManhattanDistanceForAccessPort(12));
        assertEquals(2, Day03.getManhattanDistanceForAccessPort(23));
        assertEquals(31, Day03.getManhattanDistanceForAccessPort(1024));
    }

    @Test
    void getValueForAccessPortV2() {
        assertEquals(1, Day03.getValueForAccessPortV2(1));
        assertEquals(1, Day03.getValueForAccessPortV2(2));
        assertEquals(2, Day03.getValueForAccessPortV2(3));
        assertEquals(4, Day03.getValueForAccessPortV2(4));
        assertEquals(5, Day03.getValueForAccessPortV2(5));
        assertEquals(10, Day03.getValueForAccessPortV2(6));

        assertEquals(25, Day03.getValueForAccessPortV2(9));
        assertEquals(806, Day03.getValueForAccessPortV2(23));

    }
}
