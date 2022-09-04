package de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.step;

import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.Circuit;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.valueprovider.ValueProvider;

public class AndGate extends LogicGate {
	public AndGate(String leftWire, String rightWire, String targetWire) {
		super(leftWire, rightWire, targetWire);
	}

	public AndGate(ValueProvider leftInput, ValueProvider rightInput, String targetWire) {
		super(leftInput, rightInput, targetWire);
	}

	public AndGate(int leftInput, int rightInput, String targetWire) {
		super(leftInput, rightInput, targetWire);
	}

	@Override
	public Integer logicOperation(ValueProvider leftValue, ValueProvider rightValue, Circuit circuit) {
		return leftValue.value(circuit) & rightValue.value(circuit);
	}

}
