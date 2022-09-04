package de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.valueprovider.ValueProvider;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.valueprovider.ValueProviderParser;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.step.RightShiftGate;

public class RightShiftGateParser extends CircuitStepParser<RightShiftGate> {
	private static final Pattern RSHIFT_PATTERN = Pattern.compile("(\\w+)\\s*RSHIFT\\s*(\\w+)\\s*->\\s*(\\w+)");

	@Override
	public boolean matches(String line) {
		return RSHIFT_PATTERN.matcher(line).matches();
	}

	@Override
	public RightShiftGate parse(String line) {
		final Matcher matcher = RSHIFT_PATTERN.matcher(line);
		if (!matcher.find()) {
			throw new RuntimeException("Could not parse: " + line);
		}
		final ValueProvider leftInput = ValueProviderParser.parse(matcher.group(1));
		final ValueProvider rightInput = ValueProviderParser.parse(matcher.group(2));
		return new RightShiftGate(leftInput, rightInput, matcher.group(3));
	}
}
