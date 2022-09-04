package de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.valueprovider.ValueProviderParser;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.step.AndGate;

public class AndGateParser extends CircuitStepParser<AndGate> {
	private static final Pattern AND_PATTERN = Pattern.compile("(\\w+)\\s*AND\\s*(\\w+)\\s*->\\s*(\\w+)");

	@Override
	public boolean matches(String line) {
		return AND_PATTERN.matcher(line).matches();
	}

	@Override
	public AndGate parse(String line) {
		final Matcher matcher = AND_PATTERN.matcher(line);
		if (!matcher.find()) {
			throw new RuntimeException("Could not parse: " + line);
		}
		return new AndGate(ValueProviderParser.parse(matcher.group(1)), ValueProviderParser.parse(matcher.group(2)), matcher.group(3));
	}
}
