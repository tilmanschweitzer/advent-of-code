package de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.valueprovider;

import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.circuit.Circuit;

public interface ValueProvider {
	boolean isResolved(Circuit circuit);

	int value(Circuit circuit);
}
