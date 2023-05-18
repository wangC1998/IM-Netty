package com.wc.learn.view;

import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author wc
 * 顶层场景抽象类,用来封装所有窗体都有的操作方法
 */
public abstract class UIObject extends Stage {

    protected Parent root;

    /**
     * 窗体的X坐标
     */
    private double xOffset;

    /**
     * 窗体的Y坐标
     */
    private double yOffset;

    /**
     * 选取窗体上的元素
     * @param id
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T $(String id, Class<T> clazz) {
        return (T) root.lookup("#" + id);
    }

    /**
     * 清除选中的组件
     * @param listViews
     */
    public void clearViewListSelectedAll(ListView<Pane>... listViews) {

        for (ListView listView : listViews) {
            listView.getSelectionModel().clearSelection();
        }

    }

    /**
     * 窗体的移动功能
     */
    public void move() {
        root.setOnMousePressed(event -> {
            xOffset = getX() - event.getSceneX();
            yOffset = getY() - event.getSceneY();
            root.setCursor(Cursor.CLOSED_HAND);
        });


        root.setOnMouseDragged(event -> {
            setX(event.getSceneX() + xOffset);
            setY(event.getSceneY() + yOffset);
        });

        root.setOnMouseReleased(event -> {
            root.setCursor(Cursor.DEFAULT);
        });
    }

    /**
     * 初始化窗体试图
     */
    public abstract void initView();

    /**
     * 初始化窗体上的事件:例如最大化 最小化 关闭等.
     */
    public abstract void initEventDefine();

}
