package com.uosipa.chatuvolchat;

import com.uosipa.chatuvolchat.configuration.Configuration;
import org.apache.log4j.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Application is started.");
        for (int i = 0; i < Configuration.getBotsCount(); ++i) {
            Bot bot = new Bot();
            try {
                new Thread(bot).start();
            } catch (Throwable e) {
                logger.error("Bot with id " + bot.getBotId() + "is down." + e);
            }
        }
    }
}
