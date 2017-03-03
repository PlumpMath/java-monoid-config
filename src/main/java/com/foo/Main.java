package com.foo;

public class Main {

    public static void main(String... args) {

        printMyConfig(new EnumProvider<>());

printMyConfig(
    new SystemPropertyProvider<MyEnumConfig>()
            .mappend(new EnvironmentProvider<>())
            .mappend(new PropertiesProvider<>("/home/josejuan/tmp/foo.properties"))
            .mappend(new EnumProvider<>()));

    }

    private static void printMyConfig(ConfigProvider<MyEnumConfig> config) {
        out("------------------");
        out(config.getString(MyEnumConfig.SERVICE_ENDPOINT));
        out(config.getInteger(MyEnumConfig.CONNECTION_TIMEOUT));
        out(config.getBoolean(MyEnumConfig.ENABLED));
    }

    private static void out(String format, Object... args) {
        System.out.printf("%s%n", String.format(format, args));
    }

    private static void out(Object o) {
        System.out.printf("%s%n", o.toString());
    }
}
