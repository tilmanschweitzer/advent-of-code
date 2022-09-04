package de.tilmanschweitzer.adventofcode.common.parser;

public interface Tuple5<P1, P2, P3, P4, P5> extends Tuple4<P1, P2, P3, P4> {
	P5 getValue5();
}
