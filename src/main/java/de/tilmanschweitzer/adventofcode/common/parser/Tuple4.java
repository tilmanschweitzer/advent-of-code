package de.tilmanschweitzer.adventofcode.common.parser;

public interface Tuple4<P1, P2, P3, P4> extends Tuple3<P1, P2, P3> {
	P4 getValue4();
}
