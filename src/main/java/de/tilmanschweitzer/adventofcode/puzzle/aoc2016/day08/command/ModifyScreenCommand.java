package de.tilmanschweitzer.adventofcode.puzzle.aoc2016.day08.command;

import de.tilmanschweitzer.adventofcode.puzzle.aoc2016.day08.screen.Screen;

public interface ModifyScreenCommand {

    void apply(Screen screen);
}
