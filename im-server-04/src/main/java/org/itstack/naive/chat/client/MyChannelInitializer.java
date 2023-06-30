package org.itstack.naive.chat.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.nio.charset.Charset;


public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        // 定义数据管道
        channel.pipeline().addLast(new LineBasedFrameDecoder(1024));

        // 解码转String, 注意调整自己的编码格式
        channel.pipeline().addLast(new StringDecoder(Charset.forName("GBK")));

        // 解码转String,
        channel.pipeline().addLast(new StringEncoder(Charset.forName("GBK")));

        // 在管道中添加我们自己的接受数据的实现方法.
        channel.pipeline().addLast(new MyClientHandler());
    }
}
