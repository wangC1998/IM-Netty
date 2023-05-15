package com.wc.learn.view.chat;

import com.wc.learn.view.UIObject;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * 聊天窗口的初始化抽象类
 * @author wc
 */
public abstract class ChatInit extends UIObject {
    private static final String RESOURCE_NAME = "/fxml.chat/chat.fxml";

    protected IChatEvent chatEvent;

    public Button barChat;

    public Button barFriends;

    public Pane groupBarChat;

    public Pane groupBarFriend;


    public ChatInit(IChatEvent chatEvent) {
        this.chatEvent = chatEvent;

        // 创建聊天页面初始化,获取组件初始化
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml.chat/chat.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        setScene(scene);
        initStyle(StageStyle.TRANSPARENT);
        setResizable(false);
        this.getIcons().add(new Image("/fxml.chat/img/head/logo.png"));

        // 进行基本组件注册
        obtain();
        move();
    }



    void obtain(){
        barChat = $("bar_chat", Button.class);
        barFriends = $("bar_friend", Button.class);
        groupBarChat = $("group_bar_chat", Pane.class);
        groupBarFriend = $("group_bar_friend", Pane.class);
    }




}
