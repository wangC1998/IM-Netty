package org.itstack.naive.chat.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.SocketChannel;

import java.util.Date;


public class MyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 当客户端主动链接服务端的连接后,这个通道就是活跃的,也就是客户端与服务端建立了通信通道并且可以传输数据
     * 管道激活状态(表示连接已经建立,可以进行通信)
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        SocketChannel channel = (SocketChannel) ctx.channel();

        System.out.println("链接报告开始");
        System.out.println("链接报告信息:有以客户端连接到本服务端");
        System.out.println("链接报告IP:" + channel.localAddress().getHostString());
        System.out.println("链接报告Port:" + channel.localAddress().getPort());
        System.out.println("链接报告完毕");

        // 通知客户端链接建立成功
        String str = "您与聊天服务器链接成功" + " " + new Date() + " " + channel.localAddress().getHostString() + "\r\n";
        ByteBuf buf = Unpooled.buffer(str.getBytes().length);
        buf.writeBytes(str.getBytes("GBK"));
        ctx.writeAndFlush(buf);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端断开链接"+ctx.channel().localAddress().toString());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 接收msg消息
        System.out.println(new Date() + "接收到服务端的消息：" + msg);

//        ctx.writeAndFlush("服务端已接收到消息" + new Date() + " " + msg + "\r\n");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("异常信息：\r\n" + cause.getMessage());
        ctx.close();
    }
}
