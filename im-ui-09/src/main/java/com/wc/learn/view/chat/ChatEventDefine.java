package com.wc.learn.view.chat;

import com.wc.learn.view.chat.data.TalkBoxData;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

import java.util.Date;

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

        doEventTextSend();
        doEventTouchSend();
        min();
        quit();
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

    // 发送消息事件[键盘]
    private void doEventTextSend() {
        TextArea txt_input = chatInit.$("txt_input", TextArea.class);
        txt_input.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                doEventSendMsg();
            }
        });
    }

    // 发送消息事件[按钮]
    private void doEventTouchSend() {
        Label touch_send = chatInit.$("touch_send", Label.class);
        touch_send.setOnMousePressed(event -> {
            doEventSendMsg();
        });
    }

    private void doEventSendMsg() {
        TextArea txt_input = chatInit.$("txt_input", TextArea.class);
        MultipleSelectionModel selectionModel = chatInit.$("talkList", ListView.class).getSelectionModel();
        Pane selectedItem = (Pane) selectionModel.getSelectedItem();
        // 对话信息
        TalkBoxData talkBoxData = (TalkBoxData) selectedItem.getUserData();
        String msg = txt_input.getText();
        if (null == msg || "".equals(msg) || "".equals(msg.trim())) {
            return;
        }
        Date msgDate = new Date();
        // 发送消息
        System.out.println("发送消息：" + msg);
        // 发送事件给自己添加消息 自己发消息在右侧,直接进行发送.
        chatMethod.addTalkMsgRight(talkBoxData.getTalkId(), msg, msgDate, true, true, false);
        txt_input.clear();
    }


    // 好友；开启与好友发送消息 [点击发送消息时候触发 -> 添加到对话框、选中、展示对话列表]
    public void doEventOpenFriendUserSendMsg(Button sendMsgButton, String userFriendId, String userFriendNickName, String userFriendHead) {
        sendMsgButton.setOnAction(event -> {
            // 1. 添加好友到对话框
            chatMethod.addTalkBox(0, 0, userFriendId, userFriendNickName, userFriendHead, null, null, true);
            // 2. 切换到对话框窗口
            switchBarChat(chatInit.$("bar_chat", Button.class), chatInit.$("group_bar_chat", Pane.class), true);
            switchBarFriends(chatInit.$("bar_friend", Button.class), chatInit.$("group_bar_friend", Pane.class), false);
            // 3. 事件处理；填充到对话框
            System.out.println("事件处理；填充到对话框");
        });
    }

    // 群组；开启与群组发送消息
    public void doEventOpenFriendGroupSendMsg(Button sendMsgButton, String groupId, String groupName, String groupHead) {
        sendMsgButton.setOnAction(event -> {
            // 1. 添加好友到对话框
            chatMethod.addTalkBox(0, 1, groupId, groupName, groupHead, null, null, true);
            // 2. 切换到对话框窗口
            switchBarChat(chatInit.$("bar_chat", Button.class), chatInit.$("group_bar_chat", Pane.class), true);
            switchBarFriends(chatInit.$("bar_friend", Button.class), chatInit.$("group_bar_friend", Pane.class), false);
            // 3. 事件处理；填充到对话框
            System.out.println("事件处理；填充到对话框");
        });
    }


    /**
     * 窗口的最小化按钮
     */
    public void min() {
        chatInit.min.setOnAction(event -> {
            chatInit.setIconified(true);
        });

    }


    /**
     * 关闭事件按钮
     */
    public void quit(){
        chatInit.close.setOnAction(event -> {
            chatInit.close();
            System.exit(0);
        });

    }



}
