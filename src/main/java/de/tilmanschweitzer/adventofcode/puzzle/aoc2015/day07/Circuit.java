package de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07;

import static java.util.stream.Collectors.toUnmodifiableList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.step.CircuitStep;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.valueprovider.ValueProvider;

public class Circuit {

	private Map<String, Integer> wires = new HashMap<>();

	public void applyStep(CircuitStep step) {
		step.applyStepToCircuit(this);
	}

	public Map<String, Integer> getSignalsOnWire() {
		return new TreeMap<>(wires);
	}

	public void setValueOnWire(String wire, ValueProvider valueProvider) {
		setValueOnWire(wire, valueProvider.value(this));
	}

	public void setValueOnWire(String wire, int value) {
		wires.put(wire, value);
	}

	public boolean hasValueOnWire(String wire) {
		return wires.containsKey(wire);
	}

	public Integer getValueForWire(String wire) {
		return wires.get(wire);
	}

	public void applySteps(List<CircuitStep> circuitSteps) {
		List<CircuitStep> remainingCircuitSteps = circuitSteps;

		while (!remainingCircuitSteps.isEmpty()) {
			final List<CircuitStep> resolvableCircuitSteps = remainingCircuitSteps.stream().filter(circuitStep -> circuitStep.allInputsResolved(this)).collect(toUnmodifiableList());
			if (remainingCircuitSteps.isEmpty()) {
				throw new RuntimeException("Found no resolvable circuit steps");
			}
			remainingCircuitSteps = remainingCircuitSteps.stream().filter(circuitStep -> !circuitStep.allInputsResolved(this)).collect(toUnmodifiableList());
			resolvableCircuitSteps.forEach(this::applyStep);
		}
	}
}
