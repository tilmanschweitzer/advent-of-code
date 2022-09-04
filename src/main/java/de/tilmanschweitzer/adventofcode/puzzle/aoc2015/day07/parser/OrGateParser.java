package de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.valueprovider.ValueProviderParser;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.step.OrGate;

public class OrGateParser extends CircuitStepParser<OrGate> {
	private static final Pattern OR_PATTERN = Pattern.compile("(\\w+)\\s*OR\\s*(\\w+)\\s*->\\s*(\\w+)");

	@Override
	public boolean matches(String line) {
		return OR_PATTERN.matcher(line).matches();
	}

	@Override
	public OrGate parse(String line) {
		final Matcher matcher = OR_PATTERN.matcher(line);
		if (!matcher.find()) {
			throw new RuntimeException("Could not parse: " + line);
		}
		return new OrGate(ValueProviderParser.parse(matcher.group(1)), ValueProviderParser.parse(matcher.group(2)), matcher.group(3));
	}
}
