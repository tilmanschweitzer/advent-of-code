package de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.step;

import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.circuit.Circuit;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.valueprovider.ValueProvider;

public class OrGate extends LogicGate {
	public OrGate(ValueProvider leftInput, ValueProvider rightInput, String targetWire) {
		super(leftInput, rightInput, targetWire);
	}

	public OrGate(String leftInput, String rightInput, String targetWire) {
		super(leftInput, rightInput, targetWire);
	}

	public OrGate(int leftInput, int rightInput, String targetWire) {
		super(leftInput, rightInput, targetWire);
	}

	@Override
	public Integer logicOperation(ValueProvider leftValue, ValueProvider rightValue, Circuit circuit) {
		return leftValue.value(circuit) | rightValue.value(circuit);
	}

}
