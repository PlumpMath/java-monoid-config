package com.foo;

import java.util.Optional;
import java.util.function.BiFunction;

public abstract class ConfigProvider<E extends ConfigKey> implements Monoid<ConfigProvider<E>> {

    public abstract Optional<String>  getString (E key);
    public abstract Optional<Integer> getInteger(E key);
    public abstract Optional<Boolean> getBoolean(E key);

    @Override
    public ConfigProvider<E> mappend(final ConfigProvider<E> b) {
        final ConfigProvider<E> a = this;
        return new ConfigProvider<E>() {
            @Override public Optional<String>  getString (E key) { return or(ConfigProvider::getString , key); }
            @Override public Optional<Integer> getInteger(E key) { return or(ConfigProvider::getInteger, key); }
            @Override public Optional<Boolean> getBoolean(E key) { return or(ConfigProvider::getBoolean, key); }

            private <Z> Optional<Z> or(BiFunction<ConfigProvider<E>, E, Optional<Z>> g, E key) {
                final Optional<Z> r = g.apply(a, key);
                return r.isPresent() ? r : g.apply(b, key); // where is applicative/alternative?
            }
        };
    }
}
