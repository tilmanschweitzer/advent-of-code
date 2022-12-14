package de.tilmanschweitzer.adventofcode.puzzle.aoc2015;

import de.tilmanschweitzer.adventofcode.common.parser.GenericParser;
import de.tilmanschweitzer.adventofcode.day.MultiLineAdventOfCodeDay;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.InputStream;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.ClassLoader.getSystemResourceAsStream;

public class Day14ReindeerOlympics extends MultiLineAdventOfCodeDay<Day14ReindeerOlympics.Reindeer, Integer> {

    public Day14ReindeerOlympics() {
        super(2015, 14);
    }

    @Override
    public Integer getResultOfFirstPuzzle(final List<Reindeer> reindeers) {
        final int raceDuration = 2503;
        return ReindeerRace.positionsAfterRaceDuration(reindeers, raceDuration).get(0).getDistanceAfterSeconds(raceDuration);
    }

    @Override
    public Integer getResultOfSecondPuzzle(final List<Reindeer> reindeers) {
        final int raceDuration = 2503;
        return ReindeerRace.scoresAfterRaceDuration(reindeers, raceDuration).get(0).getScore();
    }

    @Override
    protected InputStream getDefaultInputAsStream() {
        return getSystemResourceAsStream("2015/day14-input.txt");
    }

    @Override
    protected Reindeer parseLine(String line) {
        return Reindeer.parse(line);
    }

    public static class ReindeerRace {
        public static List<Reindeer> positionsAfterRaceDuration(final List<Reindeer> reindeers, final int raceDuration) {
            return reindeers.stream()
                    .sorted(Comparator.comparingInt(a -> -a.getDistanceAfterSeconds(raceDuration)))
                    .collect(Collectors.toUnmodifiableList());
        }

        public static List<Reindeer> firstPositionsAfterRaceDuration(final List<Reindeer> reindeers, final int raceDuration) {
            final List<Reindeer> reindeerByDistance = positionsAfterRaceDuration(reindeers, raceDuration);
            final int distanceOfFirstReindeer = reindeerByDistance.get(0).getDistanceAfterSeconds(raceDuration);
            return reindeerByDistance.stream().filter(reindeer -> reindeer.getDistanceAfterSeconds(raceDuration) == distanceOfFirstReindeer).collect(Collectors.toUnmodifiableList());
        }


        public static List<ReindeerScore> scoresAfterRaceDuration(List<Reindeer> reindeers, int raceDuration) {
            final Map<Reindeer, ReindeerScore> scoresByReindeer = reindeers.stream().collect(Collectors.toMap(Function.identity(), ReindeerScore::new));

            for (int i = 1; i <= raceDuration; i++) {
                final List<Reindeer> firstReindeers = firstPositionsAfterRaceDuration(reindeers, i);
                firstReindeers.stream().map(scoresByReindeer::get).forEach(ReindeerScore::incrementScore);
            }

            return scoresByReindeer.values().stream().sorted(Comparator.comparingInt(ReindeerScore::getScore).reversed()).collect(Collectors.toUnmodifiableList());
        }
    }

    @EqualsAndHashCode
    @ToString
    public static class ReindeerScore {
        final Reindeer reindeer;
        int score;

        public ReindeerScore(Reindeer reindeer) {
            this(reindeer, 0);
        }

        public ReindeerScore(Reindeer reindeer, int score) {
            this.reindeer = reindeer;
            this.score = score;
        }

        public void incrementScore() {
            score++;
        }

        public int getScore() {
            return score;
        }
    }

    @EqualsAndHashCode
    @ToString
    @Getter
    public static class Reindeer {
        private static final Function<String, Reindeer> parseFunction = GenericParser.createParserFunction(
                "(\\w+) can fly (\\d+) km/s for (\\d+) seconds, but then must rest for (\\d+) seconds",
                Reindeer::new,
                GenericParser::string,
                GenericParser::integer,
                GenericParser::integer,
                GenericParser::integer
        );

        final String name;
        final int maxSpeed;
        final int maxSpeedDuration;
        final int restDuration;

        public Reindeer(String name, int maxSpeed, int maxSpeedDuration, int restDuration) {
            this.name = name;
            this.maxSpeed = maxSpeed;
            this.maxSpeedDuration = maxSpeedDuration;
            this.restDuration = restDuration;
        }

        public static Reindeer parse(String line) {
            return parseFunction.apply(line);
        }

        public int getFullCycleDuration() {
            return maxSpeedDuration + restDuration;
        }

        public int getFullCycleDistance() {
            return maxSpeedDuration * maxSpeed;
        }

        public int getDistanceAfterSeconds(int seconds) {
            final int fullCycles = seconds / getFullCycleDuration();
            final int restSeconds = seconds % getFullCycleDuration();
            final int restSecondsWithMaxSpeed = Math.min(restSeconds, maxSpeedDuration);
            return fullCycles * getFullCycleDistance() + restSecondsWithMaxSpeed * maxSpeed;
        }
    }
}
