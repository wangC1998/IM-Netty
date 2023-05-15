package com.wc.learn.view.chat;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * 聊天窗口的事件定义
 *
 * @author wc
 */
public class ChatEventDefine {
    private ChatInit chatInit;

    private IChatEvent chatEvent;

    private IChatMethod chatMethod;


    public ChatEventDefine(ChatInit chatInit, IChatEvent chatEvent, IChatMethod chatMethod) {
        this.chatInit = chatInit;
        this.chatEvent = chatEvent;
        this.chatMethod = chatMethod;
    }


    /**
     * 切换为聊天页面
     * 交互逻辑: 根据toggle条件,定义样式的图片以及两个框体的隐藏和展现
     * @param barChat
     * @param groupBarChat
     * @param toggle
     */
    public void switchBarChat(Button barChat, Pane groupBarChat, boolean toggle) {
        if (toggle) {
            chatInit.barChat.setStyle("-fx-background-image: url('/fxml.chat/img/system/chat_2.png')");
            chatInit.groupBarChat.setVisible(true);
        } else {
            chatInit.barChat.setStyle("-fx-background-image: url('/fxml.chat/img/system/chat_0.png')");
            chatInit.groupBarChat.setVisible(false);
        }

    }


    /**
     * 切换为朋友页面
     * @param barFriends
     * @param groupBarFriends
     * @param toggle
     */
    public void switchBarFriends(Button barFriends, Pane groupBarFriends, boolean toggle) {
        if (toggle) {
            chatInit.barFriends.setStyle("-fx-background-image: url('/fxml.chat/img/system/friend_2.png')");
            chatInit.groupBarFriend.setVisible(true);
        } else {
            chatInit.barFriends.setStyle("-fx-background-image: url('/fxml.chat/img/system/friend_0.png')");
            chatInit.groupBarFriend.setVisible(false);
        }

    }

    /**
     * 聊天按钮事件
     * 交互逻辑:
     */
    public void barChat() {
        Button bar_chat = chatInit.barChat;
        Pane group_bar_chat = chatInit.groupBarChat;
        Button bar_friend = chatInit.barFriends;
        Pane group_bar_friend = chatInit.groupBarFriend;


        bar_chat.setOnAction(event -> {
            switchBarChat(bar_chat, group_bar_chat, true);
            switchBarFriends(bar_friend, group_bar_friend, false);
        });

        // 鼠标移出: 聊天焦点着色
        bar_chat.setOnMouseEntered(event -> {
            boolean visible = group_bar_chat.isVisible();
            if (visible) return;
            bar_chat.setStyle("-fx-background-image: url('/fxml.chat/img/system/chat_1.png')");
        });
        // 鼠标移出: 聊天焦点失色
        bar_chat.setOnMouseExited(event -> {
            boolean visible = group_bar_chat.isVisible();
            if (visible) return;
            bar_chat.setStyle("-fx-background-image: url('/fxml.chat/img/system/chat_0.png')");
        });



    }

    /**
     * 朋友按钮事件
     */
    public void barFriends() {
        Button bar_chat = chatInit.barChat;
        Pane group_bar_chat = chatInit.groupBarChat;
        Button bar_friend = chatInit.barFriends;
        Pane group_bar_friend = chatInit.groupBarFriend;

        bar_friend.setOnAction(event -> {
            switchBarChat(bar_chat, group_bar_chat, false);
            switchBarFriends(bar_friend, group_bar_friend, true);
        });


        // 鼠标移出: 聊天焦点着色
        bar_friend.setOnMouseEntered(event -> {
            boolean visible = group_bar_friend.isVisible();
            if (visible) return;
            bar_friend.setStyle("-fx-background-image: url('/fxml.chat/img/system/friend_1.png')");
        });
        // 鼠标移出: 聊天焦点失色
        bar_friend.setOnMouseExited(event -> {
            boolean visible = group_bar_friend.isVisible();
            if (visible) return;
            bar_friend.setStyle("-fx-background-image: url('/fxml.chat/img/system/friend_0.png')");
        });
    }



}
