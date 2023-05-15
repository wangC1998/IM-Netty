package com.wc.learn;

import com.wc.learn.view.chat.ChatController;
import com.wc.learn.view.chat.IChatEvent;
import com.wc.learn.view.chat.IChatMethod;
import com.wc.learn.view.login.ILoginMethod;
import com.wc.learn.view.login.LoginController;
import javafx.application.Application;
import javafx.stage.Stage;

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

    }

    public static void main(String[] args) {
        launch(args);
    }
}
