package de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.step;

import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.circuit.Circuit;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.valueprovider.ValueProvider;

public class NotGate extends LogicGate {
	public NotGate(String baseWire, String targetWire) {
		super(baseWire, "", targetWire);
	}

	@Override
	public Integer logicOperation(ValueProvider baseValue, ValueProvider ignoredValue, Circuit circuit) {
		return 65536 + ~baseValue.value(circuit);

	}

	@Override
	public boolean allInputsResolved(Circuit circuit) {
		return leftInput.isResolved(circuit); // ignore right input
	}

}
