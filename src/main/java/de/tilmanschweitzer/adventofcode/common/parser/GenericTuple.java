package de.tilmanschweitzer.adventofcode.common.parser;

import lombok.Value;

@Value
class GenericTuple<P1, P2, P3, P4, P5, P6, P7> implements Tuple7<P1, P2, P3, P4, P5, P6, P7> {
	P1 value1;
	P2 value2;
	P3 value3;
	P4 value4;
	P5 value5;
	P6 value6;
	P7 value7;
}
