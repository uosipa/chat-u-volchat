package com.uosipa.chatuvolchat.uconnect;

import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.Message;
import com.uosipa.chatuvolchat.protocol.Interop;
import com.uosipa.chatuvolchat.protocol.lobby.Lobby;
import com.uosipa.chatuvolchat.protocol.room.Room;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.Socket;

/**
 * @author Sergey Akimov (akimovsa@gmail.com)
 */
public class Connector {
    private InputStream socketInputStream;
    private OutputStream socketOutputStream;

    private ExtensionRegistry registry;

    public Connector(String serverHost, int serverPortResponse) throws IOException {
        Socket socket = new Socket(serverHost, serverPortResponse);
        socketInputStream = socket.getInputStream();
        socketOutputStream = socket.getOutputStream();

        initialize();
    }

    private void initialize() {
        registry = ExtensionRegistry.newInstance();
        registry.add(Lobby.chooseRoom);
        registry.add(Room.chatMessage);
    }

    public void send(Message message) throws IOException {
        socketOutputStream.write(getIntegerAsBytes(message.getSerializedSize()));
        message.writeTo(socketOutputStream);
    }

    private static byte[] getIntegerAsBytes(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("Incorrect command length.");
        }

        byte[] result = new byte[4];
        for (int i = 0; i < 4; i++) {
            result[i] = (byte) (length >> (8 * (3 - i)));
        }

        return result;
    }

    private static int getMessageLengthFromBytes(byte[] bytes) {
        if (bytes.length != 4) {
            throw new IllegalArgumentException("Message length must be 4 bytes.");
        }

        int result = 0;
        for (int i = 0; i < 4; i++) {
            result <<= 8;
            int dummy = 0;
            for (int j = 0; j < 8; j++) {
                dummy <<= 1;
                dummy |= (bytes[i] >> (byte) (7 - j)) & 1;
            }
            result |= dummy;
        }

        return result;
    }

    private int receiveInt() throws IOException {
        byte[] lengthBytes = new byte[4];
        if (lengthBytes.length != socketInputStream.read(lengthBytes)) {
            throw new IOException("The end of the stream is detected.");
        }

        return getMessageLengthFromBytes(lengthBytes);
    }

    private byte[] receiveMessageAsBytes() throws IOException {
        int length = receiveInt();
        byte[] bytes = new byte[length];
        if (bytes.length != socketInputStream.read(bytes)) {
            throw new IOException("The end of the stream is detected.");
        }

        return bytes;
    }

    public Message receiveCommand() throws IOException {
        byte[] message = receiveMessageAsBytes();

        Interop.MessageContainer messageContainer = Interop.MessageContainer.parseFrom(message, registry);

        for (Field field : messageContainer.getClass().getFields()) {
            if (field.getName().equals("chooseRoom")) {
                //TODO do something
            } else if (field.getName().equals("chatMessage")) {
                //TODO do something else
            }
        }

        Interop.MessageContainer.Type type = messageContainer.getType();

        switch (type) {
            case NOTIFICATION:
                break;
            case REQUEST:
                break;
            case RESPONSE:
                break;
        }

        throw new IllegalStateException("Can't receive or create command.");
    }
}
