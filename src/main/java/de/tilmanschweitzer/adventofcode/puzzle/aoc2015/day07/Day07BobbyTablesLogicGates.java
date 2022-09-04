package de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07;

import de.tilmanschweitzer.adventofcode.day.MultiLineAdventOfCodeDay;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.parser.AndGateParser;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.parser.CircuitStepParser;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.parser.LeftShiftGateParser;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.parser.NotGateParser;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.parser.OrGateParser;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.parser.ProvideValueToWireParser;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.parser.RightShiftGateParser;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.step.CircuitStep;
import de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07.step.ProvideValueToWire;

import java.io.InputStream;
import java.util.*;

import static java.lang.ClassLoader.getSystemResourceAsStream;

public class Day07BobbyTablesLogicGates extends MultiLineAdventOfCodeDay<CircuitStep, Integer> {

    public Day07BobbyTablesLogicGates() {
        super(2015, 7);
    }

    @Override
    public Integer getResultOfFirstPuzzle(final List<CircuitStep> circuitSteps) {
        final Circuit circuit = new Circuit();
        circuit.applySteps(circuitSteps);
        return circuit.getValueForWire("a");
    }

    @Override
    public Integer getResultOfSecondPuzzle(final List<CircuitStep> inputCircuitSteps) {
        final ArrayList<CircuitStep> circuitSteps = new ArrayList<>(inputCircuitSteps);
        final Circuit circuit = new Circuit();

        // Overwrite wire b with value from first puzzle
        final int resultOfFirstPuzzle = (int) getResultOfFirstPuzzle(inputCircuitSteps);
        circuitSteps.add(new ProvideValueToWire(resultOfFirstPuzzle, "b"));

        circuit.applySteps(circuitSteps);
        return circuit.getValueForWire("a");
    }

    @Override
    protected InputStream getDefaultInputAsStream() {
        return getSystemResourceAsStream("2015/day07-input.txt");
    }

    @Override
    protected CircuitStep parseLine(String line) {
        final List<CircuitStepParser<?>> parsers = List.of(
                new ProvideValueToWireParser(),
                new AndGateParser(),
                new OrGateParser(),
                new LeftShiftGateParser(),
                new RightShiftGateParser(),
                new NotGateParser()
        );

        for (CircuitStepParser<?> parser : parsers) {
            if (parser.matches(line)) {
                return parser.parse(line);
            }
        }

        throw new RuntimeException("Unknown circuit step: " + line);
    }
}
