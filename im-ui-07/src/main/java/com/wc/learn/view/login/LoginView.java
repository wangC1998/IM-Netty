package com.wc.learn.view.login;

/**
 * 窗体试图拓展包装.
 * @author wc
 */
public class LoginView {

    private LoginInit loginInit;

    private ILoginEvent loginEvent;

    public LoginView(LoginInit loginInit, ILoginEvent loginEvent) {
        this.loginInit = loginInit;
        this.loginEvent = loginEvent;
    }
}
