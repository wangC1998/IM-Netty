package com.wc.learn.socket.handler;

import com.wc.chat.protocol.login.LoginResponse;
import com.wc.learn.application.UIService;
import com.wc.learn.socket.MyBizHandler;
import io.netty.channel.Channel;

public class LoginHandler extends MyBizHandler<LoginResponse> {


    public LoginHandler(UIService uiService) {
        super(uiService);
    }

    @Override
    public void channelRead(Channel channel, LoginResponse msg) {
        // 处理客户端的响应状态, 进行业务操作.

    }
}
