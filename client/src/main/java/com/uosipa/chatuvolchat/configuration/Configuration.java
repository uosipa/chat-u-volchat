package com.uosipa.chatuvolchat.configuration;

import java.io.IOException;
import java.util.Properties;

public class Configuration {
    private static final Properties properties = new Properties();

    static {
        try {
            properties.load(Configuration.class.getResourceAsStream("/application.properties"));
        } catch (IOException e) {
            throw new IllegalStateException("Can't load application properties.", e);
        }
    }

    public static String getServerHost() {
        return properties.getProperty("server.host");
    }

    public static int getServerPort() {
        return Integer.parseInt(properties.getProperty("server.port"));
    }

    public static int getBotsCount() {
        return Integer.parseInt(properties.getProperty("bots.count"));
    }
}
