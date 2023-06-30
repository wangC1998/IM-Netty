package org.itstack.naive.chat.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * NettyServer
 * 服务端启动类
 * 1.创建两个线程组 bossGroup 和 workerGroup
 * 2.bossGroup 只是处理连接请求，真正的和客户端业务处理，会交给 workerGroup完成
 * 3.两个都是无限循环
 * 4.bossGroup 和 workerGroup 含有的子线程(NioEventLoop)的个数
 */
public class NettyServer {
    public static void main(String[] args) {
        new NettyServer().bing(7397);
    }

    private void bing(int port) {
        // 定义两个 NioEventLoopGroup, 一个用于承担链接请求,另一个承担通信数据.
        NioEventLoopGroup parentGroup = new NioEventLoopGroup();

        NioEventLoopGroup childGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap b = new ServerBootstrap()
                    .group(parentGroup, childGroup)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childHandler(new MyChannelInitializer())
                    .channel(NioServerSocketChannel.class);

            ChannelFuture f = b.bind(port).sync();
            System.out.println("server start done");
            f.channel().closeFuture().sync();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            childGroup.shutdownGracefully();
            parentGroup.shutdownGracefully();
        }



    }
}
