package com.wc.chat.protocol.login;

import com.wc.chat.protocol.Command;
import com.wc.chat.protocol.Packet;
import com.wc.chat.protocol.login.dto.ChatTaklDto;
import com.wc.chat.protocol.login.dto.GroupsDto;
import com.wc.chat.protocol.login.dto.UserFriendDto;

import java.util.ArrayList;
import java.util.List;

/**
 * 登录响应数据包
 * @author wc
 */
public class LoginResponse extends Packet {
    public LoginResponse(boolean success, String userId, String userHead, String userNickName, List<ChatTaklDto> chatTalkList, List<GroupsDto> groupsList, List<UserFriendDto> userFriendDto) {
        this.success = success;
        this.userId = userId;
        this.userHead = userHead;
        this.userNickName = userNickName;
        this.chatTalkList = chatTalkList;
        this.groupsList = groupsList;
        this.userFriendDto = userFriendDto;
    }

    private boolean success;

    private String userId;

    private String userHead;

    private String userNickName;

    private List<ChatTaklDto> chatTalkList = new ArrayList<>();

    private List<GroupsDto> groupsList = new ArrayList<>();

    private List<UserFriendDto> userFriendDto = new ArrayList<>();

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserHead() {
        return userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public List<ChatTaklDto> getChatTalkList() {
        return chatTalkList;
    }

    public void setChatTalkList(List<ChatTaklDto> chatTalkList) {
        this.chatTalkList = chatTalkList;
    }

    public List<GroupsDto> getGroupsList() {
        return groupsList;
    }

    public void setGroupsList(List<GroupsDto> groupsList) {
        this.groupsList = groupsList;
    }

    public List<UserFriendDto> getUserFriendDto() {
        return userFriendDto;
    }

    public void setUserFriendDto(List<UserFriendDto> userFriendDto) {
        this.userFriendDto = userFriendDto;
    }

    @Override
    public Byte getCommand() {
        return Command.LoginResponse;
    }
}
