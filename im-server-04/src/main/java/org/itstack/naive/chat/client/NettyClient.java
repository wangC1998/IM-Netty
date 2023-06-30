package org.itstack.naive.chat.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient {

    public static void main(String[] args) {
        new NettyClient().connect("127.0.0.1" ,7397);

    }

    private void connect(String inetHost, int inetPort) {
        // `1. 创建时间循环组,用于处理通信管道数据   用于处理I/O操作的多线程事件循环器
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        // 2. 创建一个Bootstrap对象，用于启动客户端
        Bootstrap b = new Bootstrap();
        b.group(workerGroup);
        b.channel(NioSocketChannel.class);
        b.option(ChannelOption.AUTO_READ, true);
        b.handler(new MyChannelInitializer());

        try {
            ChannelFuture f = b.connect(inetHost, inetPort).sync();
            System.out.println("client start done");
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            workerGroup.shutdownGracefully();
        }
    }
}
