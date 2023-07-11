package com.wc.learn.event;

import com.wc.chat.protocol.login.LoginRequest;
import com.wc.learn.infrastructure.util.CacheUtil;
import io.netty.channel.Channel;


import com.wc.learn.infrastructure.util.BeanUtil;
import org.itstack.naive.chat.ui.view.login.ILoginEvent;

public class LoginEvent implements ILoginEvent {
    @Override
    public void doLoginCheck(String userId, String userPassword) {
        // 获取channel
        Channel channel = BeanUtil.getBean("channel", Channel.class);

        // 向服务端发起请求
        channel.writeAndFlush(new LoginRequest(userId, userPassword));

        // 缓存数据
        CacheUtil.userId = userId;

    }
}
