package com.wc.chat.protocol.login;
import com.wc.chat.protocol.Command;
import com.wc.chat.protocol.Packet;

/**
 * 登录请求数据包
 * @author wc
 */
public class LoginRequest extends Packet{

    public LoginRequest(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 密码
     */
    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Byte getCommand() {
        return Command.LoginRequest;
    }
}
