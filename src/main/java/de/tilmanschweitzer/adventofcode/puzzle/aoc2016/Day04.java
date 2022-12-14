package de.tilmanschweitzer.adventofcode.puzzle.aoc2016;

import de.tilmanschweitzer.adventofcode.common.parser.GenericParser;
import de.tilmanschweitzer.adventofcode.day.MultiLineAdventOfCodeDay;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static de.tilmanschweitzer.adventofcode.common.CollectionFunctions.sum;
import static de.tilmanschweitzer.adventofcode.common.Converters.charsToString;
import static de.tilmanschweitzer.adventofcode.common.Converters.stringToCharList;
import static java.lang.ClassLoader.getSystemResourceAsStream;

public class Day04 extends MultiLineAdventOfCodeDay<Day04.Room, Integer> {

    public Day04() {
        super(2016, 4);
    }

    @Override
    public Integer getResultOfFirstPuzzle(final List<Room> rooms) {
        return sum(rooms.stream().filter(Room::isValid).map(Room::getId));
    }

    @Override
    public Integer getResultOfSecondPuzzle(final List<Room> rooms) {
        return rooms.stream().filter(room -> Objects.equals(room.getDecryptedName(), "northpole object storage")).findFirst().get().getId();
    }

    @Override
    public Room parseLine(String line) {
        return Room.parse(line);
    }

    @Override
    protected InputStream getDefaultInputAsStream() {
        return getSystemResourceAsStream("2016/day04-input.txt");
    }

    @EqualsAndHashCode
    @Getter
    @ToString
    public static class Room {

        private static final Function<String, Room> parserFunction = GenericParser.createParserFunction(
                "([a-z-]+)-(\\d+)\\[([a-z]+)]",
                Room::new,
                GenericParser::string,
                GenericParser::integer,
                GenericParser::string
        );

        final String encryptedName;
        final int id;
        final String checksum;

        public Room(String encryptedName, int id, String checksum) {
            this.encryptedName = encryptedName;
            this.id = id;
            this.checksum = checksum;
        }

        public static Room parse(String line) {
            return parserFunction.apply(line);
        }

        public boolean isValid() {
            return checksum.equals(getCalculatedCheckSum()); // && hasValidEncryptionScheme();
        }

        public String getCalculatedCheckSum() {
            return getCharsWithCount().stream().map(CharCount::getC).map(Objects::toString).limit(5).collect(Collectors.joining());
        }

        public List<CharCount> getCharsWithCount() {
            return getUniqueCharsInOrder().stream().map(uniqueChar -> CharCount.of(uniqueChar, countChar(uniqueChar))).sorted().collect(Collectors.toUnmodifiableList());
        }

        public int countChar(char charToBeCounted) {
            return (int) stringToCharList(encryptedName).stream().filter(c -> c == charToBeCounted).count();
        }

        public List<Character> getAllChars() {
            return stringToCharList(encryptedName.replaceAll("-", ""));
        }

        public List<Character> getUniqueCharsInOrder() {
            return stringToCharList(getAllChars().stream().map(Object::toString).reduce(Room::concatUnique).orElse(""));
        }

        private static String concatUnique(String a, String b) {
            if (a.contains(b)) {
                return a;
            }
            return a + b;
        }

        public String getDecryptedName() {
            return charsToString(stringToCharList(encryptedName).stream().map(c -> {
                if (c == '-') {
                    return ' ';
                }
                return (char) (((c - 'a' + getId()) % 26) + 'a');
            }));
        }

        @EqualsAndHashCode
        @Getter
        public static class CharCount implements Comparable<CharCount> {
            final char c;
            final int count;

            private CharCount(char c, int count) {
                this.c = c;
                this.count = count;
            }

            public static CharCount of(char c, int count) {
                return new CharCount(c, count);
            }

            public static CharCount of(char c) {
                return new CharCount(c, 1);
            }

            @Override
            public int compareTo(CharCount o) {
                if (o.count == count) {
                    return c - o.c;
                }
                return o.count - count;
            }
        }

    }
}
