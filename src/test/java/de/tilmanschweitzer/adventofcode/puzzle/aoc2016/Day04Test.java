package de.tilmanschweitzer.adventofcode.puzzle.aoc2016;

import de.tilmanschweitzer.adventofcode.puzzle.aoc2016.Day04;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2016.Day04.Room;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2016.Day04.Room.CharCount;
import org.junit.jupiter.api.Test;

import java.util.List;

import static de.tilmanschweitzer.adventofcode.common.Converters.stringToCharList;
import static org.junit.jupiter.api.Assertions.*;

class Day04Test {


    @Test
    void getResultOfFirstPuzzle() {
        assertEquals(185371, new Day04().getResultOfFirstPuzzle());
    }

    @Test
    void getResultOfSecondPuzzle() {
        assertEquals(984, new Day04().getResultOfSecondPuzzle());
    }

    @Test
    void parse() {
        assertEquals(new Room("aaaaa-bbb-z-y-x", 123, "abxyz"), Room.parse("aaaaa-bbb-z-y-x-123[abxyz]"));
    }

    @Test
    void getAllChars() {
        assertEquals(stringToCharList("aaaaabbbzyx"), Room.parse("aaaaa-bbb-z-y-x-123[abxyz]").getAllChars());
    }

    @Test
    void getUniqueCharsInOrder() {
        assertEquals(stringToCharList("abzyx"), Room.parse("aaaaa-bbb-z-y-x-123[abxyz]").getUniqueCharsInOrder());
        assertEquals(stringToCharList("azdbui"), Room.parse("azdaabuiiaiai-123[azdbui]").getUniqueCharsInOrder());
    }

    @Test
    void getCharsWithCount() {
        final List<CharCount> expectedCharCounts = List.of(CharCount.of('a', 5), CharCount.of('b', 3), CharCount.of('x'), CharCount.of('y'), CharCount.of('z'));
        assertEquals(expectedCharCounts, Room.parse("aaaaa-bbb-z-y-x-123[abxyz]").getCharsWithCount());

        final List<CharCount> expectedCharCounts2 = List.of(CharCount.of('e', 3), CharCount.of('f', 2), CharCount.of('h', 2), CharCount.of('d'), CharCount.of('g'), CharCount.of('i'));
        assertEquals(expectedCharCounts2, Room.parse("d-eee-ff-g-hh-i-123[efhdg]").getCharsWithCount());
    }

    @Test
    void getCalculatedCheckSum() {
        assertEquals("abxyz", Room.parse("aaaaa-bbb-z-y-x-123[abxyz]").getCalculatedCheckSum());
        assertEquals("abcde", Room.parse("a-b-c-d-e-f-g-h-987[abcde]").getCalculatedCheckSum());
    }

    @Test
    void isValid() {
        assertTrue(Room.parse("aaaaa-bbb-z-y-x-123[abxyz]").isValid());
        assertTrue(Room.parse("a-b-c-d-e-f-g-h-987[abcde]").isValid());
        assertTrue(Room.parse("not-a-real-room-404[oarel]").isValid());
        assertFalse(Room.parse("totally-real-room-200[decoy]").isValid());
    }

    @Test
    void getDecryptedName() {
        assertEquals("b", Room.parse("a-1[q]").getDecryptedName());
        assertEquals("z", Room.parse("a-25[q]").getDecryptedName());
        assertEquals("a", Room.parse("a-26[q]").getDecryptedName());
        assertEquals("very encrypted name", Room.parse("qzmt-zixmtkozy-ivhz-343[zimth]").getDecryptedName());
    }
}
