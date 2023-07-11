package com.wc.chat.codec;

import com.wc.chat.protocol.Packet;
import com.wc.chat.util.SerializationUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 编码器
 * 虫洞栈：https://bugstack.cn
 * 公众号：bugstack虫洞栈  ｛关注获取学习源码｝
 */
public class ObjEncoder extends MessageToByteEncoder<Packet> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Packet in, ByteBuf out) {
        byte[] data = SerializationUtil.serialize(in);
        // 在数据包前面添加1位数据包长度,用来存储数据的类型
        out.writeInt(data.length + 1);
        out.writeByte(in.getCommand()); //添加指令,用来辨别具体的对象类型
        out.writeBytes(data);
    }

}
