package com.wc.learn.domain.inet.repository;

import com.wc.learn.domain.inet.model.ChannelUserInfo;
import com.wc.learn.domain.inet.model.ChannelUserReq;
import java.util.List;

/**
 * 博  客：http://bugstack.cn
 * 公众号：bugstack虫洞栈 | 沉淀、分享、成长，让自己和他人都能有所收获！
 * create by 小傅哥 on @2020
 */
public interface IInetRepository {

    Long queryChannelUserCount(ChannelUserReq req);

    List<ChannelUserInfo> queryChannelUserList(ChannelUserReq req);

}
