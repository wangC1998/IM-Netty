package com.wc.chat.protocol;


import com.wc.chat.protocol.login.LoginRequest;
import com.wc.chat.protocol.login.LoginResponse;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 协议包
 */
public abstract class Packet {

    private final static Map<Byte, Class<? extends Packet>> packetType = new ConcurrentHashMap<>();

    static {
        packetType.put(Command.LoginRequest, LoginRequest.class);
        packetType.put(Command.LoginResponse, LoginResponse.class);
    }

    public static Class<? extends Packet> get(Byte command) {
        return packetType.get(command);
    }

    /**
     * 获取协议指令
     *
     * @return 返回指令值
     */
    public abstract Byte getCommand();

}
