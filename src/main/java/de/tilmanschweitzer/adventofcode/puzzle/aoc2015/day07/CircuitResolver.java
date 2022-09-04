package de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07;

import static java.util.stream.Collectors.toUnmodifiableList;

import java.util.List;

import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.circuit.Circuit;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.step.CircuitStep;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CircuitResolver {
	public static void resolve(Circuit circuit, List<CircuitStep> circuitSteps) {
		List<CircuitStep> remainingCircuitSteps = circuitSteps;

		while (!remainingCircuitSteps.isEmpty()) {
			final List<CircuitStep> resolvableCircuitSteps = remainingCircuitSteps.stream()
					.filter(circuitStep -> circuitStep.allInputsResolved(circuit))
					.collect(toUnmodifiableList());

			if (remainingCircuitSteps.isEmpty()) {
				throw new RuntimeException("Found no resolvable circuit steps");
			}
			remainingCircuitSteps = remainingCircuitSteps.stream()
					.filter(circuitStep -> !circuitStep.allInputsResolved(circuit))
					.collect(toUnmodifiableList());

			resolvableCircuitSteps.forEach(step -> step.applyStepToCircuit(circuit));
		}
	}
}
