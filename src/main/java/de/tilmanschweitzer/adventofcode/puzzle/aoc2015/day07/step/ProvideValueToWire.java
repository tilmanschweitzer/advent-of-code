package de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.step;

import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.Circuit;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.valueprovider.ValueProvider;

public class ProvideValueToWire extends SingleInputCircuitStep {
	public ProvideValueToWire(ValueProvider input, String targetWire) {
		super(input, targetWire);
	}

	public ProvideValueToWire(int input, String targetWire) {
		super(input, targetWire);
	}

	public ProvideValueToWire(String input, String targetWire) {
		super(input, targetWire);
	}

	@Override
	public void applyStepToCircuit(Circuit circuit) {
		circuit.setValueOnWire(targetWire, input);
	}

}
