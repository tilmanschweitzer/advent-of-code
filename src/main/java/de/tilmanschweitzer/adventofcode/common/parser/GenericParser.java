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

        return (line) -> {
            final Matcher matcher = compiledPattern.matcher(line);
            if (!matcher.find()) {
                throw new RuntimeException("Could not parse line: " + line);
            }
            final Tuple<P1, P2> values = valuesFromMatcher(matcher, p1, p2);
            return constructorFn.apply(values.getValue1(), values.getValue2());
        };
    }

    public static <P1, P2, P3, R> Function<String, R> createParserFunction(
            String pattern,
            Function3<P1, P2, P3, R> constructorFn,
            Function<String, P1> p1,
            Function<String, P2> p2,
            Function<String, P3> p3
    ) {
        final Pattern compiledPattern = Pattern.compile(pattern);

        return (line) -> {
            final Matcher matcher = compiledPattern.matcher(line);
            if (!matcher.find()) {
                throw new RuntimeException("Could not parse line: " + line);
            }
            final Tuple3<P1, P2, P3> values = valuesFromMatcher(matcher, p1, p2, p3);
            return constructorFn.apply(values.getValue1(), values.getValue2(), values.getValue3());
        };
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

        return (line) -> {
            final Matcher matcher = compiledPattern.matcher(line);
            if (!matcher.find()) {
                throw new RuntimeException("Could not parse line: " + line);
            }
            final Tuple4<P1, P2, P3, P4> values = valuesFromMatcher(matcher, p1, p2, p3, p4);
            return constructorFn.apply(values.getValue1(), values.getValue2(), values.getValue3(), values.getValue4());
        };
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

        return (line) -> {
            final Matcher matcher = compiledPattern.matcher(line);
            if (!matcher.find()) {
                throw new RuntimeException("Could not parse line: " + line);
            }
            final Tuple6<P1, P2, P3, P4, P5, P6> values = valuesFromMatcher(matcher, p1, p2, p3, p4, p5, p6);
            return constructorFn.apply(values.getValue1(), values.getValue2(), values.getValue3(), values.getValue4(), values.getValue5(), values.getValue6());
        };
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

        return (line) -> {
            final Matcher matcher = compiledPattern.matcher(line);
            if (!matcher.find()) {
                throw new RuntimeException("Could not parse line: " + line);
            }
            final Tuple7<P1, P2, P3, P4, P5, P6, P7> values = valuesFromMatcher(matcher, p1, p2, p3, p4, p5, p6, p7);
            return constructorFn.apply(values.getValue1(), values.getValue2(), values.getValue3(), values.getValue4(), values.getValue5(), values.getValue6(), values.getValue7());
        };
    }

    private static <P1, P2, P3, P4, P5, P6, P7> Tuple7<P1, P2, P3, P4, P5, P6, P7> valuesFromMatcher(Matcher matcher, Function<String, P1> p1, Function<String, P2> p2, Function<String, P3> p3, Function<String, P4> p4, Function<String, P5> p5, Function<String, P6> p6, Function<String, P7> p7) {
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

    private static <P1, P2, P3, P4, P5, P6> Tuple6<P1, P2, P3, P4, P5, P6> valuesFromMatcher(Matcher matcher, Function<String, P1> p1, Function<String, P2> p2, Function<String, P3> p3, Function<String, P4> p4, Function<String, P5> p5, Function<String, P6> p6) {
        return valuesFromMatcher(matcher, p1, p2, p3, p4, p5, p6, null);
    }

    private static <P1, P2, P3, P4> Tuple4<P1, P2, P3, P4> valuesFromMatcher(Matcher matcher, Function<String, P1> p1, Function<String, P2> p2, Function<String, P3> p3, Function<String, P4> p4) {
        return valuesFromMatcher(matcher, p1, p2, p3, p4, null, null);
    }

    private static <P1, P2, P3> Tuple3<P1, P2, P3> valuesFromMatcher(Matcher matcher, Function<String, P1> p1, Function<String, P2> p2, Function<String, P3> p3) {
        return valuesFromMatcher(matcher, p1, p2, p3, null, null, null);
    }

    private static <P1, P2> Tuple<P1, P2> valuesFromMatcher(Matcher matcher, Function<String, P1> p1, Function<String, P2> p2) {
        return valuesFromMatcher(matcher, p1, p2, null, null, null, null);
    }

    public interface Value<P1> {
        P1 getValue1();
    }

    public interface Tuple<P1, P2> extends Value<P1> {
        P2 getValue2();
    }

    public interface Tuple3<P1, P2, P3> extends Tuple<P1, P2> {
        P3 getValue3();
    }

    public interface Tuple4<P1, P2, P3, P4> extends Tuple3<P1, P2, P3> {
        P4 getValue4();
    }

    public interface Tuple5<P1, P2, P3, P4, P5> extends Tuple4<P1, P2, P3, P4> {
        P5 getValue5();
    }

    public interface Tuple6<P1, P2, P3, P4, P5, P6> extends Tuple5<P1, P2, P3, P4, P5> {
        P6 getValue6();
    }

    public interface Tuple7<P1, P2, P3, P4, P5, P6, P7> extends Tuple6<P1, P2, P3, P4, P5, P6> {
        P7 getValue7();
    }

    @lombok.Value
    public static class GenericTuple<P1, P2, P3, P4, P5, P6, P7> implements Tuple7<P1, P2, P3, P4, P5, P6, P7> {
        P1 value1;
        P2 value2;
        P3 value3;
        P4 value4;
        P5 value5;
        P6 value6;
        P7 value7;
    }

    @FunctionalInterface
    public interface Function2<P1, P2, R> {
        public R apply(P1 param1, P2 param2);
    }

    @FunctionalInterface
    public interface Function3<P1, P2, P3, R> {
        public R apply(P1 param1, P2 param2, P3 param3);
    }

    @FunctionalInterface
    public interface Function4<P1, P2, P3, P4, R> {
        public R apply(P1 param1, P2 param2, P3 param3, P4 param4);
    }

    @FunctionalInterface
    public interface Function6<P1, P2, P3, P4, P5, P6, R> {
        public R apply(P1 param1, P2 param2, P3 param3, P4 param4, P5 param5, P6 param6);
    }

    @FunctionalInterface
    public interface Function7<P1, P2, P3, P4, P5, P6, P7, R> {
        public R apply(P1 param1, P2 param2, P3 param3, P4 param4, P5 param5, P6 param6, P7 param7);
    }
}
