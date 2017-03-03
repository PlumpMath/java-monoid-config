package com.foo;

import java.util.Optional;

public class EnumProvider<E extends Enum<E> & ConfigKey & EnumBackend> extends KeyValueProvider<E> {
    @Override
    public Optional<String> getString(E key) {
        return key.getPersistence();
    }
}
