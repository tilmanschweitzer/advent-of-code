package de.tilmanschweitzer.adventofcode.common.parser;


import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenericParser {

    public static Integer integer(String s) {
        return Integer.parseInt(s);
    }

    public static String string(String s) {
        return s;
    }

    public static <P1, P2, R> Function<String, R> createParserFunction(
            String pattern,
            Function2<P1, P2, R> constructorFn,
            Function<String, P1> p1,
            Function<String, P2> p2
    ) {
        final Pattern compiledPattern = Pattern.compile(pattern);
        return (line) -> constructorFn.apply(valuesFromPattern(compiledPattern, line, p1, p2));
    }

    public static <P1, P2, P3, R> Function<String, R> createParserFunction(
            String pattern,
            Function3<P1, P2, P3, R> constructorFn,
            Function<String, P1> p1,
            Function<String, P2> p2,
            Function<String, P3> p3
    ) {
        final Pattern compiledPattern = Pattern.compile(pattern);
        return (line) -> constructorFn.apply(valuesFromPattern(compiledPattern, line, p1, p2, p3));
    }

    public static <P1, P2, P3, P4, R> Function<String, R> createParserFunction(
            String pattern,
            Function4<P1, P2, P3, P4, R> constructorFn,
            Function<String, P1> p1,
            Function<String, P2> p2,
            Function<String, P3> p3,
            Function<String, P4> p4
    ) {
        final Pattern compiledPattern = Pattern.compile(pattern);
        return (line) -> constructorFn.apply(valuesFromPattern(compiledPattern, line, p1, p2, p3, p4));
    }

    public static <P1, P2, P3, P4, P5, R> Function<String, R> createParserFunction(
            String pattern,
            Function5<P1, P2, P3, P4, P5, R> constructorFn,
            Function<String, P1> p1,
            Function<String, P2> p2,
            Function<String, P3> p3,
            Function<String, P4> p4,
            Function<String, P5> p5
    ) {
        final Pattern compiledPattern = Pattern.compile(pattern);
        return (line) -> constructorFn.apply(valuesFromPattern(compiledPattern, line, p1, p2, p3, p4, p5));
    }

    public static <P1, P2, P3, P4, P5, P6, R> Function<String, R> createParserFunction(
            String pattern,
            Function6<P1, P2, P3, P4, P5, P6, R> constructorFn,
            Function<String, P1> p1,
            Function<String, P2> p2,
            Function<String, P3> p3,
            Function<String, P4> p4,
            Function<String, P5> p5,
            Function<String, P6> p6
    ) {
        final Pattern compiledPattern = Pattern.compile(pattern);
        return (line) -> constructorFn.apply(valuesFromPattern(compiledPattern, line, p1, p2, p3, p4, p5, p6));
    }

    public static <P1, P2, P3, P4, P5, P6, P7, R> Function<String, R> createParserFunction(
            String pattern,
            Function7<P1, P2, P3, P4, P5, P6, P7, R> constructorFn,
            Function<String, P1> p1,
            Function<String, P2> p2,
            Function<String, P3> p3,
            Function<String, P4> p4,
            Function<String, P5> p5,
            Function<String, P6> p6,
            Function<String, P7> p7
    ) {
        final Pattern compiledPattern = Pattern.compile(pattern);
        return (line) -> constructorFn.apply(valuesFromPattern(compiledPattern, line, p1, p2, p3, p4, p5, p6, p7));
    }

    private static <P1, P2, P3, P4, P5, P6, P7> Tuple7<P1, P2, P3, P4, P5, P6, P7> valuesFromPattern(
            Pattern pattern,
            String line,
            Function<String, P1> p1,
            Function<String, P2> p2,
            Function<String, P3> p3,
            Function<String, P4> p4,
            Function<String, P5> p5,
            Function<String, P6> p6,
            Function<String, P7> p7
    ) {
        final Matcher matcher = pattern.matcher(line);
        if (!matcher.find()) {
            throw new RuntimeException("Could not parse line: " + line);
        }
        final P1 value1 = valueFromMatcherGroup(p1, matcher, 1);
        final P2 value2 = valueFromMatcherGroup(p2, matcher, 2);
        final P3 value3 = valueFromMatcherGroup(p3, matcher, 3);
        final P4 value4 = valueFromMatcherGroup(p4, matcher, 4);
        final P5 value5 = valueFromMatcherGroup(p5, matcher, 5);
        final P6 value6 = valueFromMatcherGroup(p6, matcher, 6);
        final P7 value7 = valueFromMatcherGroup(p7, matcher, 7);
        return new GenericTuple<>(value1, value2, value3, value4, value5, value6, value7);
    }

    private static <P> P valueFromMatcherGroup(Function<String, P> p, Matcher matcher, int group) {
        if (p == null) {
            return null;
        }
        return p.apply(matcher.group(group));
    }

    private static <P1, P2, P3, P4, P5, P6> Tuple6<P1, P2, P3, P4, P5, P6> valuesFromPattern(
            Pattern pattern,
            String line,
            Function<String, P1> p1,
            Function<String, P2> p2,
            Function<String, P3> p3,
            Function<String, P4> p4,
            Function<String, P5> p5,
            Function<String, P6> p6
    ) {
        return valuesFromPattern(pattern, line, p1, p2, p3, p4, p5, p6, null);
    }

    private static <P1, P2, P3, P4, P5> Tuple5<P1, P2, P3, P4, P5> valuesFromPattern(
            Pattern pattern,
            String line,
            Function<String, P1> p1,
            Function<String, P2> p2,
            Function<String, P3> p3,
            Function<String, P4> p4,
            Function<String, P5> p5
    ) {
        return valuesFromPattern(pattern, line, p1, p2, p3, p4, p5, null, null);
    }

    private static <P1, P2, P3, P4> Tuple4<P1, P2, P3, P4> valuesFromPattern(
            Pattern pattern,
            String line,
            Function<String, P1> p1,
            Function<String, P2> p2,
            Function<String, P3> p3,
            Function<String, P4> p4
    ) {
        return valuesFromPattern(pattern, line, p1, p2, p3, p4, null, null, null);
    }

    private static <P1, P2, P3> Tuple3<P1, P2, P3> valuesFromPattern(
            Pattern pattern,
            String line,
            Function<String, P1> p1,
            Function<String, P2> p2,
            Function<String, P3> p3
    ) {
        return valuesFromPattern(pattern, line, p1, p2, p3, null, null, null, null);
    }

    private static <P1, P2> Tuple2<P1, P2> valuesFromPattern(
            Pattern pattern,
            String line,
            Function<String, P1> p1,
            Function<String, P2> p2
    ) {
        return valuesFromPattern(pattern, line, p1, p2, null, null, null, null, null);
    }
}
