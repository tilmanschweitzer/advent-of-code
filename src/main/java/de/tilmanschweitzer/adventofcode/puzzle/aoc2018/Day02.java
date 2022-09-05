package de.tilmanschweitzer.adventofcode.puzzle.aoc2018;

import static java.lang.ClassLoader.getSystemResourceAsStream;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import de.tilmanschweitzer.adventofcode.common.Converters;
import de.tilmanschweitzer.adventofcode.day.MultiLineAdventOfCodeDay;

public class Day02 extends MultiLineAdventOfCodeDay<String, Long> {

    public Day02() {
        super(2018, 1);
    }

    public static long countNumberOfLettersByOccurrence(String line, int occurrence) {
        final Map<Character, Long> countByChars = Converters.stringToCharStream(line).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return countByChars.entrySet().stream().filter(entry -> entry.getValue() == occurrence).count();
    }

    public static long countNumberOfLinesWithLettersMatchingTheOccurrence(List<String> lines, int occurrence) {
        return lines.stream().filter(line -> countNumberOfLettersByOccurrence(line, occurrence) > 0).count();
    }

    @Override
    public Long getResultOfFirstPuzzle(final List<String> lines) {
        return countNumberOfLinesWithLettersMatchingTheOccurrence(lines, 2) * countNumberOfLinesWithLettersMatchingTheOccurrence(lines, 3);
    }

    @Override
    public Long getResultOfSecondPuzzle(final List<String> lines) {
        return 0L;
    }

    @Override
    public String parseLine(String line) {
        return line;
    }

    @Override
    protected InputStream getDefaultInputAsStream() {
        return getSystemResourceAsStream("2018/day02-input.txt");
    }

}
