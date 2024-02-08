package org.dreambot.api.methods.filter;

public interface Filter<T> {
	default Filter<T> and(Filter<? super T> other) {
		return e -> match(e) && other.match(e);
	}
	
	boolean match(T acceptable);
	
	default Filter<T> negate() {
		return e -> !match(e);
	}
	
	default Filter<T> or(Filter<? super T> other) {
		return e -> match(e) || other.match(e);
	}
}
