package de.tilmanschweitzer.adventofcode.common.parser;

public interface Tuple2<P1, P2> extends Value<P1> {
	P2 getValue2();
}
