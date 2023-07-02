package org.itstack.naive.chat.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.itstack.naive.chat.codec.ObjDecoder;
import org.itstack.naive.chat.codec.ObjEncoder;
import org.itstack.naive.chat.domain.MsgInfo;

import java.nio.charset.Charset;

public class MyChannelInitializerWithPB extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        // 使用自定义的编码解码器
        channel.pipeline().addLast(new ObjDecoder(MsgInfo.class));

        channel.pipeline().addLast(new ObjEncoder(MsgInfo.class));

        // 在管道中添加我们自己的接受数据的实现方法.
        channel.pipeline().addLast(new MyServerHandler());
    }
}
