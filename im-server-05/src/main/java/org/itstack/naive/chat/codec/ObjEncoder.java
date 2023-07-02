package org.itstack.naive.chat.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.itstack.naive.chat.protocol.Packet;
import org.itstack.naive.chat.util.SerializationUtil;

public class ObjEncoder extends MessageToByteEncoder<Packet> {



    @Override
    protected void encode(ChannelHandlerContext ctx, Packet in, ByteBuf out) throws Exception {

        byte[] data = SerializationUtil.serialize(in);
        // 增加1位写入长度,用作帧标识,进行序列换的对象转换
        out.writeInt(data.length + 1);
        out.writeByte(in.getCommand());
        out.writeBytes(data);
    }
}
