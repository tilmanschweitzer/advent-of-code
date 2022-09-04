package de.tilmanschweitzer.adventofcode.common.parser;

@FunctionalInterface
public interface Function2<P1, P2, R> {
	R apply(P1 param1, P2 param2);

	default R apply(Tuple2<P1, P2> tuple) {
		return this.apply(tuple.getValue1(), tuple.getValue2());
	}
}
