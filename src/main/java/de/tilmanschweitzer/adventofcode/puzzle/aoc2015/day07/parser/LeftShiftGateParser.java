package de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.valueprovider.ValueProvider;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.valueprovider.ValueProviderParser;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.step.LeftShiftGate;

public class LeftShiftGateParser extends CircuitStepParser<LeftShiftGate> {
	private static final Pattern LSHIFT_PATTERN = Pattern.compile("(\\w+)\\s*LSHIFT\\s*(\\w+)\\s*->\\s*(\\w+)");

	@Override
	public boolean matches(String line) {
		return LSHIFT_PATTERN.matcher(line).matches();
	}

	@Override
	public LeftShiftGate parse(String line) {
		final Matcher matcher = LSHIFT_PATTERN.matcher(line);
		if (!matcher.find()) {
			throw new RuntimeException("Could not parse: " + line);
		}
		final ValueProvider leftInput = ValueProviderParser.parse(matcher.group(1));
		final ValueProvider rightInput = ValueProviderParser.parse(matcher.group(2));
		return new LeftShiftGate(leftInput, rightInput, matcher.group(3));
	}
}
