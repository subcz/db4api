package org.dreambot.api.utilities.impl;

public interface Condition {
	default Condition and(Condition c) {
		return () -> verify() && c.verify();
	}
	
	default Condition negate() {
		return () -> !verify();
	}
	
	default Condition not(Condition c) {
		return () -> !c.verify();
	}
	
	default Condition or(Condition c) {
		return () -> verify() || c.verify();
	}
	
	boolean verify();
}
