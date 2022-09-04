package de.tilmanschweitzer.adventofcode.common.parser;

@FunctionalInterface
public interface Function1<P1, R> {
	R apply(P1 param1);

	default R apply(Value<P1> tuple) {
		return this.apply(tuple.getValue1());
	}
}
