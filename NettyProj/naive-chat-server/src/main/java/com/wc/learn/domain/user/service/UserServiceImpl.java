package com.wc.learn.domain.user.service;

import com.wc.learn.application.UserService;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 博  客：http://bugstack.cn
 * 公众号：bugstack虫洞栈 | 沉淀、分享、成长，让自己和他人都能有所收获！
 * create by 小傅哥 on @2020
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private ThreadPoolTaskExecutor taskExecutor;

    //默认线程池
    private static ExecutorService executorService = Executors.newFixedThreadPool(4);

}
