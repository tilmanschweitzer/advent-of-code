package de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.step;

import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.Circuit;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.valueprovider.NumericValueProvider;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.valueprovider.ValueProvider;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.valueprovider.WireValueProvider;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public abstract class DoubleInputCircuitStep extends CircuitStep {
	final ValueProvider leftInput;
	final ValueProvider rightInput;
	final String targetWire;

	protected DoubleInputCircuitStep(ValueProvider leftInput, ValueProvider rightInput, String targetWire) {
		this.leftInput = leftInput;
		this.rightInput = rightInput;
		this.targetWire = targetWire;
	}

	protected DoubleInputCircuitStep(String leftInput, String rightInput, String targetWire) {
		this(new WireValueProvider(leftInput), new WireValueProvider(rightInput), targetWire);
	}

	protected DoubleInputCircuitStep(int leftInput, int rightInput, String targetWire) {
		this(new NumericValueProvider(leftInput), new NumericValueProvider(rightInput), targetWire);
	}

	@Override
	public boolean allInputsResolved(Circuit circuit) {
		return leftInput.isResolved(circuit) && rightInput.isResolved(circuit);
	}
}
