package org.itstack.naive.chat.ui;

import com.wc.learn.application.UIService;
import com.wc.learn.event.ChatEvent;
import com.wc.learn.event.LoginEvent;
import com.wc.learn.socket.NettyClient;
import io.netty.channel.Channel;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.itstack.naive.chat.ui.view.chat.element.group_bar_friend.ElementFriendLuckUser;
import org.itstack.naive.chat.ui.view.chat.ChatController;
import org.itstack.naive.chat.ui.view.chat.IChatEvent;
import org.itstack.naive.chat.ui.view.chat.IChatMethod;
import org.itstack.naive.chat.ui.view.login.ILoginMethod;
import org.itstack.naive.chat.ui.view.login.LoginController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

/**
 * 窗口          Stage
 * -场景       Scene
 * -布局     stackPane
 * -控件   Button
 */
public class Application extends javafx.application.Application {

    Logger logger = LoggerFactory.getLogger(Application.class);

    private static ExecutorService executorService = Executors.newFixedThreadPool(2);

    private static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    @Override
    public void start(Stage primaryStage) throws Exception {

        IChatMethod chat = new ChatController(new ChatEvent());
        LoginController login = new LoginController(new LoginEvent(), chat);

        login.doShow();

        UIService uiService = new UIService();
        uiService.setLogin(login);
        uiService.setChat(chat);

        // 2. 启动socket链接
        logger.info("Netty链接服务开始 inetHost:{}, inetPort: {}", "127.0.0.1", 7397);

        NettyClient nettyClient = new NettyClient(uiService);
        Future<Channel> channelFuture = executorService.submit(nettyClient);
        Channel channel = channelFuture.get();

        if (channel == null) {
            throw new RuntimeException("socket client start error. ");
        }

        while (!channel.isActive()) {
            // TODO: 2023/7/11 这里会是一个断线重连的地方
            logger.info("Netty链接服务中 ...");
            Thread.sleep(500);
        }

        logger.info("Netty链接服务完成 {}", channel.localAddress());
    }

    public static void main(String[] args) {
        launch(args);
    }

}
