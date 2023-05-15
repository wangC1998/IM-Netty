package com.wc.learn.view.login;

public interface ILoginEvent {
    /**
     * 交互事件-登录按钮后的检查
     * @param userId
     * @param userPassword
     */
    void doLoginCheck(String userId, String userPassword);
}
