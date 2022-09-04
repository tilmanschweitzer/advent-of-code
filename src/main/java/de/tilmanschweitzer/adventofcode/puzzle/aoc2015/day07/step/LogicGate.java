package de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.step;

import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.circuit.Circuit;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.valueprovider.ValueProvider;

public abstract class LogicGate extends DoubleInputCircuitStep {

	public LogicGate(ValueProvider leftInput, ValueProvider rightInput, String targetWire) {
		super(leftInput, rightInput, targetWire);
	}

	public LogicGate(String leftInput, String rightInput, String targetWire) {
		super(leftInput, rightInput, targetWire);
	}

	public LogicGate(int leftInput, int rightInput, String targetWire) {
		super(leftInput, rightInput, targetWire);
	}

	@Override
	public void applyStepToCircuit(Circuit circuit) {
		final Integer newValue = logicOperation(leftInput, rightInput, circuit);
		circuit.setValueOnWire(targetWire, newValue);
	}

	public abstract Integer logicOperation(ValueProvider leftValue, ValueProvider rightValue, Circuit circuit);

}
