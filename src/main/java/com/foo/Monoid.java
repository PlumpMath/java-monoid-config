package com.foo;

public interface Monoid<T> {
    T mappend(T other);
}
