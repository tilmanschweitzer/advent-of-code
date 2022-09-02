package de.tilmanschweitzer.adventofcode.puzzle.aoc2016.day08.screen;

import java.util.List;

public interface Screen {

	void turnOn(int x, int y);

	void setOn(int x, int y, boolean state);

	List<Boolean> getRow(int y);

	List<Boolean> getColumn(int x);

	long countLights();
}
