package de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.valueprovider;

import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.circuit.Circuit;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class NumericValueProvider implements ValueProvider {

	private final int value;

	public NumericValueProvider(int value) {
		this.value = value;
	}

	@Override
	public boolean isResolved(Circuit circuit) {
		return true;
	}

	@Override
	public int value(Circuit circuit) {
		return value;
	}
}
