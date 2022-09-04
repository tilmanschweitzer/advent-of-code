package de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.step;

import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.Circuit;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.valueprovider.NumericValueProvider;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.valueprovider.ValueProvider;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.valueprovider.WireValueProvider;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public abstract class SingleInputCircuitStep extends CircuitStep {
	final ValueProvider input;
	final String targetWire;

	protected SingleInputCircuitStep(ValueProvider input, String targetWire) {
		this.input = input;
		this.targetWire = targetWire;
	}

	protected SingleInputCircuitStep(int input, String targetWire) {
		this.input = new NumericValueProvider(input);
		this.targetWire = targetWire;
	}

	protected SingleInputCircuitStep(String input, String targetWire) {
		this.input = new WireValueProvider(input);
		this.targetWire = targetWire;
	}

	@Override
	public boolean allInputsResolved(Circuit circuit) {
		return input.isResolved(circuit);
	}
}
