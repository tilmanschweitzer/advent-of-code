package de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.step;

import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.valueprovider.ValueProvider;

public class LeftShiftGate extends ShiftGate {

	public LeftShiftGate(ValueProvider leftInput, ValueProvider rightInput, String targetWire) {
		super(leftInput, rightInput, targetWire);
	}

	public LeftShiftGate(String leftInput, int rightInput, String targetWire) {
		super(leftInput, rightInput, targetWire);
	}

	public LeftShiftGate(int leftInput, int rightInput, String targetWire) {
		super(leftInput, rightInput, targetWire);
	}

	@Override
	public int shiftOperation(int leftValue, int rightValue) {
		return leftValue << rightValue;
	}

}
