package com.wc.learn.socket.handler;

import com.alibaba.fastjson.JSON;
import com.wc.chat.protocol.login.LoginRequest;
import com.wc.learn.application.UserService;
import com.wc.learn.socket.MyBizHandler;
import io.netty.channel.Channel;

public class LoginHandler extends MyBizHandler<LoginRequest> {

    public LoginHandler(UserService userService) {
        super(userService);
    }

    @Override
    public void channelRead(Channel channel, LoginRequest msg) {
        // 接收到客户端的登录请求, 进行业务处理, 返回登录后的请求结果.
        System.out.println(JSON.toJSONString(msg));

    }
}
