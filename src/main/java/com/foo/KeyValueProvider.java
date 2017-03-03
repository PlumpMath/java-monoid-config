package com.foo;

import java.util.Optional;

public abstract class KeyValueProvider<E extends ConfigKey> extends ConfigProvider<E> {

    @Override
    public Optional<Integer> getInteger(E key) {
        return getString(key).flatMap(KeyValueProvider::parseInt);
    }

    @Override
    public Optional<Boolean> getBoolean(E key) {
        return getString(key).flatMap(KeyValueProvider::parseBool);
    }

    private static Optional<Integer> parseInt(String data) {
        try {
            return Optional.of(Integer.parseInt(data));
        } catch (Exception ignore) {
            return Optional.empty();
        }
    }

    private static Optional<Boolean> parseBool(String data) {
        if("true" .equalsIgnoreCase(data)) return Optional.of(true );
        if("false".equalsIgnoreCase(data)) return Optional.of(false);
        return Optional.empty();
    }
}
