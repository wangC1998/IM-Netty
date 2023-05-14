package com.wc.learn.view.login;

/**
 * 登录窗口事件定义
 * @author wc
 */
public class LoginEventDefine {
    private LoginInit loginInit;

    private ILoginEvent loginEvent;

    private ILoginMethod loginMethod;


    public LoginEventDefine(LoginInit loginInit, ILoginEvent loginEvent, ILoginMethod loginMethod) {
        this.loginInit = loginInit;
        this.loginEvent = loginEvent;
        this.loginMethod = loginMethod;

        // 进行窗体初始化相关事件注册
        loginInit.move();
        this.min();
        this.quit();
        this.doEventLogin();
    }

    /**
     * 窗口的最小化按钮
     */
    public void min() {
        loginInit.loginMin.setOnAction(event -> {
            loginInit.setIconified(true);
        });

    }


    /**
     * 关闭事件按钮
     */
    public void quit(){
        loginInit.loginClose.setOnAction(event -> {
            loginInit.close();
            System.exit(0);
        });

    }

    /**
     * 登录事件按钮
     */
    public void doEventLogin(){
        loginInit.loginOn.setOnAction(event -> {
            loginEvent.doLoginCheck(loginInit.userId.getText(),
                    loginInit.userPassWord.getText());
        });

    }
}
