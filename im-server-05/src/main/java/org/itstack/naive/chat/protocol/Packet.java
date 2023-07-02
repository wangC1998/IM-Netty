package org.itstack.naive.chat.protocol;

import org.itstack.naive.chat.domain.MsgInfo;
import org.itstack.naive.chat.protocol.demo.Demo1;
import org.itstack.naive.chat.protocol.demo.Demo2;
import org.itstack.naive.chat.protocol.demo.Demo3;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Packet {

    private final static Map<Byte, Class<? extends Packet>> packetType = new ConcurrentHashMap<>();

    static {
        packetType.put(Command.MsgInfo, MsgInfo.class);
    }

    public static Class<? extends Packet> getPacketType(byte command) {
        return packetType.get(command);
    }

    /**
     * 获取对象标识
     * @return
     */
    public abstract Byte getCommand();

}
