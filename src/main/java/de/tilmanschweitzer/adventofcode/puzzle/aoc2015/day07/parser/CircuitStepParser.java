package de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.parser;

import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.step.CircuitStep;

public abstract class CircuitStepParser<T extends CircuitStep> {
	public abstract boolean matches(String line);

	public abstract T parse(String line);
}
