package org.itstack.naive.chat.socket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import org.itstack.naive.chat.codec.ObjDecoder;
import org.itstack.naive.chat.codec.ObjEncoder;

public class MyChannelInitializerWithPB extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        // 自定义的编码解码器
        channel.pipeline().addLast(new ObjDecoder());

        // TODO: 2023/7/2 增加自己的业务处理器


        // 自定义解码器
        channel.pipeline().addLast(new ObjEncoder());
    }
}
