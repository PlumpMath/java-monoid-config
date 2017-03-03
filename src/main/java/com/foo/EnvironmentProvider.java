package com.foo;

import java.util.Optional;

public class EnvironmentProvider<E extends ConfigKey> extends KeyValueProvider<E> {
    @Override
    public Optional<String> getString(E key) {
        return Optional.ofNullable(System.getenv(key.getName()));
    }
}