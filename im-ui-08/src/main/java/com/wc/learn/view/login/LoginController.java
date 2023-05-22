package com.wc.learn.view.login;

/**
 * 登录窗口控制器
 * @author wc
 */
public class LoginController extends LoginInit implements ILoginMethod {
    private LoginView loginView;

    private LoginEventDefine loginEventDefine;

    public LoginController(ILoginEvent loginEvent) {
        super(loginEvent);
    }

    @Override
    public void initView() {
        loginView = new LoginView(this, loginEvent);
    }

    @Override
    public void initEventDefine() {
        loginEventDefine = new LoginEventDefine(this, loginEvent, this);
    }

    @Override
    public void doShow() {
        super.show();
    }

    @Override
    public void doLoginError() {
        System.out.println("登录失败,执行提示操作");

    }

    @Override
    public void doLoginSuccess() {
        System.out.println("登录成功,执行跳转操作");
        close(); // 将当前窗口关闭.
    }
}
