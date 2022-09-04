package de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.valueprovider;

public class ValueProviderParser {

	public static ValueProvider parse(String input) {
		if (input.matches("\\d+")) {
			return new NumericValueProvider(Integer.parseInt(input));
		}
		if (input.matches("[a-zA-Z]+")) {
			return new WireValueProvider(input);
		}
		throw new RuntimeException("Could not parse value: " + input);
	}
}
