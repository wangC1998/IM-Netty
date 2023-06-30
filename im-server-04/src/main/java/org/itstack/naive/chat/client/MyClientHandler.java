package org.itstack.naive.chat.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.SocketChannel;
import java.util.Date;


public class MyClientHandler extends ChannelInboundHandlerAdapter {

    public MyClientHandler() {
    }

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
        System.out.println("链接报告信息:本客户端连接到服务端. channelId:" + channel.id());
        System.out.println("链接报告IP:" + channel.localAddress().getHostString());
        System.out.println("链接报告Port:" + channel.localAddress().getPort());
        System.out.println("链接报告完毕");


        String str = "通知服务端链接成功 " + new Date() + channel.localAddress().getHostString() + "\r\n";
        ctx.writeAndFlush(str);
    }

    /**
     * 当客户端主动断开服务端的连接后,这个通道就是不活跃的,也就是说客户端与服务端的关闭了通信通道并且不可以传输数据
     * 管道休眠状态(表示连接已经断开,不可以进行通信)
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        // 关闭流
        System.out.println("客户端关闭");
    }

    /**
     * 读取服务端传输过来的消息
     * 读取管道中数据事件(服务端向客户端发送消息时触发)
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 接受msg消息{与上一章节相比，此处已经不需要自己进行解码}
        System.out.println(new Date() + "接收到消息：" + msg);
        // 通知您已经链接上客户端
        String str = "您好服务端端,我已经收到您的消息" + new Date() + " " + msg + "\r\n";
        System.out.println(str);

//        ctx.writeAndFlush(str);
    }

    /**
     * 异常处理
     * 通信管道发生异常事件(服务端向客户端发送消息时触发)
     * @param ctx
     * @param cause
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        System.out.println("异常退出:" + cause.getMessage());
        ctx.close();
    }
}
