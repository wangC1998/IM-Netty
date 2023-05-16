package com.wc.learn;

import com.wc.learn.view.chat.ChatController;
import com.wc.learn.view.chat.IChatEvent;
import com.wc.learn.view.chat.IChatMethod;
import com.wc.learn.view.login.ILoginMethod;
import com.wc.learn.view.login.LoginController;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Date;

/**
 *
 * @author wc
 */
public class MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
//        ILoginMethod login = new LoginController((userId, userPassword) -> System.out.println("登录的userId:" + userId + ", 登录的密码:" + userPassword));
//        login.doShow();

        IChatMethod chat = new ChatController(null);
        chat.doShow();

        // 模拟测试
        chat.addTalkBox(-1, 0, "1000001", "小傅哥", "01_50", "我不是一个简单的男人", new Date(), true);
        chat.addTalkBox(-1, 0, "1000002", "铁锤", "02_50", "有本事现时里扎一下", new Date(), false);
        chat.addTalkBox(-1, 0, "1000003", "团团", "03_50", "秋风扫过树叶落，哪有棋盘哪有我", new Date(), false);
        chat.addTalkBox(-1, 0, "1000004", "哈尼克兔", "04_50", "你把爱放在我的心里", new Date(), false);
        chat.addTalkBox(0, 1, "5307397", "虫洞 · 技术栈(1区)", "group_1", "小傅哥：吉祥健康、如意安康", new Date(), false);


    }

    public static void main(String[] args) {
        launch(args);
    }
}
