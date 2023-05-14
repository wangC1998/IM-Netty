package com.wc.learn;

import com.wc.learn.view.Login;
import com.wc.learn.view.login.ILoginEvent;
import com.wc.learn.view.login.ILoginMethod;
import com.wc.learn.view.login.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author wc
 */
public class MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        ILoginMethod login = new LoginController(new ILoginEvent() {
            @Override
            public void doLoginCheck(String userId, String userPassword) {
                System.out.println("登录的userId:" + userId + ", 登录的密码:" + userPassword);
            }
        });

        login.doShow();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
