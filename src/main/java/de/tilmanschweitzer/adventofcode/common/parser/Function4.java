package de.tilmanschweitzer.adventofcode.common.parser;

@FunctionalInterface
public interface Function4<P1, P2, P3, P4, R> {
	R apply(P1 param1, P2 param2, P3 param3, P4 param4);

	default R apply(Tuple4<P1, P2, P3, P4> tuple) {
		return this.apply(tuple.getValue1(), tuple.getValue2(), tuple.getValue3(), tuple.getValue4());
	}
}
