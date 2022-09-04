package de.tilmanschweitzer.adventofcode.common.parser;

@FunctionalInterface
public interface Function3<P1, P2, P3, R> {
	R apply(P1 param1, P2 param2, P3 param3);

	default R apply(Tuple3<P1, P2, P3> tuple) {
		return this.apply(tuple.getValue1(), tuple.getValue2(), tuple.getValue3());
	}
}
