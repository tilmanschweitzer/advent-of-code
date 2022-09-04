package de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.valueprovider;

import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.Circuit;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class WireValueProvider implements ValueProvider {
	private final String wire;

	public WireValueProvider(String wire) {
		this.wire = wire;
	}

	@Override
	public boolean isResolved(Circuit circuit) {
		return circuit.hasValueOnWire(wire);
	}

	@Override
	public int value(Circuit circuit) {
		return circuit.getValueForWire(wire);
	}
}
