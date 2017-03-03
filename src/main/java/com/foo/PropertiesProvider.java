package com.foo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

public class PropertiesProvider<E extends ConfigKey> extends KeyValueProvider<E> {

    private final Optional<Properties> file;

    public PropertiesProvider(String filePath) {
        file = readFile(filePath);
    }

    @Override
    public Optional<String> getString(E key) {
        return file.flatMap(p -> Optional.ofNullable(p.getProperty(key.getName())));
    }

    private static Optional<Properties> readFile(String filePath) {
        try (FileInputStream fs = new FileInputStream(filePath)) {
            final Properties p = new Properties();
            p.load(fs);
            return Optional.of(p);
        } catch (IOException ignore) {
            return Optional.empty();
        }
    }
}