package com.wc.learn.view.chat;

import java.util.Date;

/**
 * 登录窗口的对外接口方法
 * @author wc
 */
public interface IChatMethod {
    /**
     * 展示聊天窗口
     */
    void doShow();

    /**
     * 填充对话框列表
     *
     * @param talkIdx       对话框位置;首位0, 默认-1
     * @param talkType      对话框类型;好友0, 群组1
     * @param talkId        对话框ID, 1V1聊天ID, 1VN聊天ID
     * @param talkName      对话框名称
     * @param talkHead      对话框头像
     * @param talkSketch    对话框通信件数(聊天内容最后一组信息)
     * @param talkDate      对话框通信事件
     * @param selected      选中[true / false]
     */
    void addTalkBox(int talkIdx, Integer talkType, String talkId, String talkName, String talkHead, String talkSketch,
                    Date talkDate, Boolean selected);
}
