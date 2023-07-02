package org.itstack.naive.chat.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import org.itstack.naive.chat.codec.ObjDecoder;
import org.itstack.naive.chat.codec.ObjEncoder;

public class MyChannelInitializerWithPB extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        // 使用自定义的编码解码器
        channel.pipeline().addLast(new ObjDecoder());

        channel.pipeline().addLast(new ObjEncoder());

        // 在管道中添加我们自己的接受数据的实现方法.
        channel.pipeline().addLast(new MyClientHandler());
    }
}
