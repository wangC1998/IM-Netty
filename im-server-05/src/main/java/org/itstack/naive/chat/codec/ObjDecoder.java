package org.itstack.naive.chat.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.itstack.naive.chat.util.SerializationUtil;

import java.util.List;

public class ObjDecoder extends ByteToMessageDecoder {

    private Class<?> genericClass;

    public ObjDecoder(Class<?> genericClass) {
        this.genericClass = genericClass;
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
        // 读取数据长度
        if (in.readableBytes() < 4) {
            return;
        }
        // 标记当前readIndex的位置
        in.markReaderIndex();
        // 读取数据长度
        int dataLength = in.readInt();
        // 判断请求数据包是否到齐
        if (in.readableBytes() < dataLength) {
            // 还原readIndex的位置
            in.resetReaderIndex();
            return;
        }
        // 读取data数据
        byte[] data = new byte[dataLength];
        in.readBytes(data);
        // 反序列化
        Object obj = SerializationUtil.deserialize(data, genericClass);
        out.add(obj);
    }
}
