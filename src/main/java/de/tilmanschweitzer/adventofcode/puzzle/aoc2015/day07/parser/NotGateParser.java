package de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.step.NotGate;

public class NotGateParser extends CircuitStepParser<NotGate> {
	private static final Pattern NOT_PATTERN = Pattern.compile("NOT\\s*(\\w+)\\s*->\\s*(\\w+)");

	@Override
	public boolean matches(String line) {
		return NOT_PATTERN.matcher(line).matches();
	}

	@Override
	public NotGate parse(String line) {
		final Matcher matcher = NOT_PATTERN.matcher(line);
		if (!matcher.find()) {
			throw new RuntimeException("Could not parse: " + line);
		}
		return new NotGate(matcher.group(1), matcher.group(2));
	}
}
