package de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.step;

import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.Circuit;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.valueprovider.NumericValueProvider;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.valueprovider.ValueProvider;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.valueprovider.WireValueProvider;

public abstract class ShiftGate extends DoubleInputCircuitStep {
	public ShiftGate(ValueProvider leftInput, ValueProvider rightInput, String targetWire) {
		super(leftInput, rightInput, targetWire);
	}

	public ShiftGate(String leftInput, int rightInput, String targetWire) {
		super(new WireValueProvider(leftInput), new NumericValueProvider(rightInput), targetWire);
	}

	public ShiftGate(int leftInput, int rightInput, String targetWire) {
		super(leftInput, rightInput, targetWire);
	}

	@Override
	public void applyStepToCircuit(Circuit circuit) {
		final int baseValue = leftInput.value(circuit);
		final int shiftValue = rightInput.value(circuit);
		final int newValue = shiftOperation(baseValue, shiftValue);
		circuit.setValueOnWire(targetWire, newValue);
	}

	public abstract int shiftOperation(int leftValue, int rightValue);
}
