package com.wc.learn.view.chat;

/**
 * 聊天窗体试图
 * @author wc
 */
public class ChatView {

    private ChatInit chatInit;

    private IChatEvent chatEvent;

    public ChatView(ChatInit chatInit, IChatEvent chatEvent) {
        this.chatInit = chatInit;
        this.chatEvent = chatEvent;
    }
}
