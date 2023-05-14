package com.wc.learn.view.chat;

/**
 * 聊天窗口的控制器
 */
public class ChatController extends ChatInit implements IChatMethod {

    private ChatView chatView;

    private ChatEventDefine chatEventDefine;

    public ChatController(IChatEvent chatEvent) {
        super(chatEvent);

        initView();
        initEventDefine();

        chatEventDefine.barChat();
        chatEventDefine.barFriends();
    }

    @Override
    public void initView() {
        chatView = new ChatView(this, chatEvent);
    }

    @Override
    public void initEventDefine() {
        chatEventDefine = new ChatEventDefine(this, chatEvent, this);
    }

    @Override
    public void doShow() {
        super.show();
    }
}
