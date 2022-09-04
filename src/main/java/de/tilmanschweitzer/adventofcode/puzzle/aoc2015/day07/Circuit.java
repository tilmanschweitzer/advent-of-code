package de.tilmanschweitzer.adventofcode.puzzle.aoc2015.day07;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Circuit {

	private Map<String, Integer> wires = new HashMap<>();

	public Map<String, Integer> getSignalsOnWire() {
		return new TreeMap<>(wires);
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

}
