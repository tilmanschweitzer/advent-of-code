package de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.step;

import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.valueprovider.ValueProvider;

public class RightShiftGate extends ShiftGate {

	public RightShiftGate(ValueProvider leftInput, ValueProvider rightInput, String targetWire) {
		super(leftInput, rightInput, targetWire);
	}

	public RightShiftGate(String leftInput, int rightInput, String targetWire) {
		super(leftInput, rightInput, targetWire);
	}

	public RightShiftGate(int leftInput, int rightInput, String targetWire) {
		super(leftInput, rightInput, targetWire);
	}

	@Override
	public int shiftOperation(int leftValue, int rightValue) {
		return leftValue >> rightValue;
	}

}
