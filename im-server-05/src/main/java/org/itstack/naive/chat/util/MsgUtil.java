package org.itstack.naive.chat.util;

import org.itstack.naive.chat.domain.MsgInfo;

/**
 * @author wc
 */
public class MsgUtil {
    public static MsgInfo buildMsg(String channelId, String msgContent) {
        return new MsgInfo(channelId,msgContent);
    }
}
