package de.tilmanschweitzer.adventofcode.puzzle.aoc2016.day08.screen;

public class DefaultScreenFactory implements ScreenFactory {

	@Override
	public Screen create(int width, int height) {
		return DefaultScreen.of(width, height);
	}
}
