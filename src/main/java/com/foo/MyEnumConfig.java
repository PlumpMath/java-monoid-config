package com.foo;

import java.util.Optional;

public enum MyEnumConfig implements EnumBackend, ConfigKey {

    SERVICE_ENDPOINT {
        @Override
        public Optional<String> getPersistence() {
            return Optional.of("http://www.google.es");
        }
    },

    CONNECTION_TIMEOUT {
        @Override
        public Optional<String> getPersistence() {
            return Optional.of("300");
        }
    },

    ENABLED {
        @Override
        public Optional<String> getPersistence() {
            return Optional.of("true");
        }
    };

    @Override
    public String getName() {
        return name();
    }

}
