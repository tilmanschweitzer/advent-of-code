package de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.step;

import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.circuit.Circuit;

public abstract class CircuitStep {
	public abstract void applyStepToCircuit(Circuit circuit);

	public abstract boolean allInputsResolved(Circuit circuit);
}
