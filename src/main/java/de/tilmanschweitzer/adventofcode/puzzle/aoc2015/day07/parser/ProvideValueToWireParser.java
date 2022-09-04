package de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.parser;

import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.valueprovider.ValueProviderParser;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.step.ProvideValueToWire;

public class ProvideValueToWireParser extends CircuitStepParser<ProvideValueToWire> {
	@Override
	public boolean matches(String line) {
		return line.matches("\\w+\\s*->\\s*\\w+");
	}

	@Override
	public ProvideValueToWire parse(String line) {
		final String[] split = line.split("->");
		return new ProvideValueToWire(ValueProviderParser.parse(split[0].trim()), split[1].trim());
	}
}
