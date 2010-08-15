package com.uosipa.chatuvolchat;

import org.apache.log4j.Logger;

import java.util.UUID;
import java.util.Random;
import java.util.Date;
import java.io.IOException;

import com.uosipa.chatuvolchat.uconnect.Connector;
import com.uosipa.chatuvolchat.configuration.Configuration;
import com.uosipa.chatuvolchat.protocol.Interop;
import com.uosipa.chatuvolchat.protocol.room.Room;
import com.uosipa.chatuvolchat.protocol.lobby.Lobby;
import com.google.protobuf.Message;

public class Bot implements Runnable {
    private final Logger logger = Logger.getLogger(Bot.class);

    private UUID botId = UUID.randomUUID();
    private Connector connector;
    private int roomId;

    public UUID getBotId() {
        return botId;
    }

    @Override
    public void run() {
        logger.info("Starting bot with id " + getBotId());

        while (true) {
            try {
                connector = new Connector(Configuration.getServerHost(), Configuration.getServerPort());
            } catch (IOException e) {
                logger.warn("Can't connect to server");
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e1) {
                        continue;
                    }
                    break;
                }
                continue;
            }

            try {
                chooseRoom();
            } catch (IOException e) {
                logger.warn("Can't choose room. IOException caught.");
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e1) {
                        continue;
                    }
                    break;
                }
                continue;
            }

            sendMessages();
        }
    }

    private void sendMessages() {
        //noinspection LoopStatementThatDoesntLoop
        while (true) {
            try {
                sendMessage(getRandomString(100));
            } catch (IOException e) {
                logger.warn("Can't send message.");
            }
            while (true) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    //no operations.
                }
            }
        }
    }

    private String getRandomString(int maxLength) {
        StringBuffer result = new StringBuffer();
        int length = (new Random().nextInt() % maxLength + maxLength) % maxLength;
        for (int i = 0; i < length; ++i) {
            result.append('a' + (new Random().nextInt() % 26 + 26) % 26);
        }

        return result.toString();
    }

    private void sendMessage(String text) throws IOException {
        connector.send(Interop.MessageContainer.newBuilder()
                .setExtension(Room.chatMessage, Room.ChatMessage.newBuilder()
                        .setRequest(Room.ChatMessage.Request.newBuilder()
                                .setRoomId(roomId)
                                .setMessage(text)
                                .build())
                        .build())
                .build());

        long sendTime = new Date().getTime();
        while (true) {
            Message message = connector.receiveCommand();
            if (!(message instanceof Room.ChatMessage)) {
                logger.info("User " + ((Lobby.ChooseRoom) message).getNotification().getName()
                        + " joined to the room " + ((Lobby.ChooseRoom) message).getNotification().getRoomId());
                continue;
            }

            Room.ChatMessage chatMessage = (Room.ChatMessage) message;

            if (chatMessage.hasNotification()) {
                logger.info(chatMessage.getNotification().getName() + ":"
                        + chatMessage.getNotification().getMessage());
                continue;
            }

            logger.info("Response for chatMessage received in " + (new Date().getTime() - sendTime) + " milliseconds.");

            break;
        }
    }

    private void chooseRoom() throws IOException {
        roomId = (new Random().nextInt() % 100 + 100) % 100;
        connector.send(Interop.MessageContainer.newBuilder()
                .setExtension(Lobby.chooseRoom, Lobby.ChooseRoom.newBuilder()
                        .setRequest(Lobby.ChooseRoom.Request.newBuilder()
                                .setRoomId(roomId)
                                .setName(getBotId().toString())
                                .build())
                        .build())
                .build());

        long sendTime = new Date().getTime();
        while (true) {
            Message message = connector.receiveCommand();
            if (!(message instanceof Lobby.ChooseRoom)) {
                logger.info(((Room.ChatMessage) message).getNotification().getName() + ":"
                        + ((Room.ChatMessage) message).getNotification().getMessage());
                continue;
            }

            Lobby.ChooseRoom chooseRoom = (Lobby.ChooseRoom) message;

            if (chooseRoom.hasNotification()) {
                logger.info("User " + chooseRoom.getNotification().getName()
                        + " joined to the room " + chooseRoom.getNotification().getRoomId());
                continue;
            }

            logger.info("Response for chooseRoom received in " + (new Date().getTime() - sendTime) + " milliseconds.");

            break;
        }
    }
}
