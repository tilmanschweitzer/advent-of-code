package de.tilmanschweitzer.adventofcode.common.parser;

@FunctionalInterface
public interface Function6<P1, P2, P3, P4, P5, P6, R> {
	R apply(P1 param1, P2 param2, P3 param3, P4 param4, P5 param5, P6 param6);

	default R apply(Tuple6<P1, P2, P3, P4, P5, P6> tuple) {
		return this.apply(tuple.getValue1(), tuple.getValue2(), tuple.getValue3(), tuple.getValue4(), tuple.getValue5(), tuple.getValue6());
	}
}
