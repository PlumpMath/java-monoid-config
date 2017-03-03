package com.foo;

import java.util.Optional;

public class SystemPropertyProvider<E extends ConfigKey> extends KeyValueProvider<E> {
    @Override
    public Optional<String> getString(E key) {
        return Optional.ofNullable(System.getProperty(key.getName()));
    }
}