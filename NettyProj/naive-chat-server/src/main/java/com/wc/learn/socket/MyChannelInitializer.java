package com.wc.learn.socket;

import com.wc.chat.codec.ObjDecoder;
import com.wc.chat.codec.ObjEncoder;
import com.wc.learn.application.UserService;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
/**
 * 博  客：http://bugstack.cn
 * 公众号：bugstack虫洞栈 | 沉淀、分享、成长，让自己和他人都能有所收获！
 * create by 小傅哥 on @2020
 */
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {

    private UserService userService;

    public MyChannelInitializer(UserService userService){
        this.userService = userService;
    }

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        //对象传输处理[解码]
        channel.pipeline().addLast(new ObjDecoder());
        // 在管道中添加我们自己的接收数据实现方法

        //对象传输处理[编码]
        channel.pipeline().addLast(new ObjEncoder());
    }

}
