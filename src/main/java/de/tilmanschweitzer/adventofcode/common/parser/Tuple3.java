package de.tilmanschweitzer.adventofcode.common.parser;

public interface Tuple3<P1, P2, P3> extends Tuple2<P1, P2> {
	P3 getValue3();
}
