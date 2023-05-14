package com.wc.learn.view.login;

import com.wc.learn.view.UIObject;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * @author wc
 * 登录窗口的初始化操作
 */
public abstract class LoginInit extends UIObject {
    private static final String RESOURCE_NAME = "/fxml.login/login.fxml";

    protected ILoginEvent loginEvent;

    public Button loginMin;
    public Button loginClose;
    public Button loginOn;
    public TextField userId;
    public PasswordField userPassWord;

    public LoginInit(ILoginEvent loginEvent) {
        this.loginEvent = loginEvent;

        // 获取根节点
        try {
            root = FXMLLoader.load(getClass().getResource(RESOURCE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(root);

        scene.setFill(Color.TRANSPARENT);
        setScene(scene);
        initStyle(StageStyle.TRANSPARENT);
        setResizable(false);
        this.getIcons().add(new Image("/fxml.login/img/system/logo.png"));

        obtain(); // 获取窗体上所有元素

        initView(); // 初始化试图
        initEventDefine(); // 初始化事件定义
    }

    /**
     * 获取该窗体上所有的元素
     */
    private void obtain() {
        loginMin = $("login_min", Button.class);
        loginClose = $("login_close", Button.class);
        loginOn = $("login_button", Button.class);
        userId = $("userId", TextField.class);
        userPassWord = $("userPassword", PasswordField.class);
    }
}
