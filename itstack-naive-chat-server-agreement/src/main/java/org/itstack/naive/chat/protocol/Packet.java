package org.itstack.naive.chat.protocol;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Packet {

    private final static Map<Byte, Class<? extends Packet>> packetType = new ConcurrentHashMap<>();

    static {
//        packetType.put(Command.MsgInfo, MsgInfo.class);
        // TODO: 2023/7/2 添加字节的对象映射.
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
