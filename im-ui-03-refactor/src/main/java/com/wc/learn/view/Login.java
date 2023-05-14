package com.wc.learn.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Login extends Stage {

    private static final String RESOURCE_NAME = "/fxml.login/login.fxml";

    private Parent root;


    public Login() {
        try {
            root = FXMLLoader.load(getClass().getResource(RESOURCE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        setScene(scene);
        initStyle(StageStyle.TRANSPARENT);
        setResizable(false);
        this.getIcons().add(new Image("/fxml.login/img/system/logo.png"));
    }


    private double xOffset;

    private double yOffset;

    /**
     * 设置窗口移动功能
     */
    public void move(){

        // 1. 鼠标按下
        root.setOnMousePressed(event -> {
            xOffset = getX() - event.getSceneX();
            yOffset = getY() - event.getSceneY();
            root.setCursor(Cursor.CLOSED_HAND);
        });


        // 2. 鼠标拖动
        root.setOnMouseDragged(event -> {
            setX(event.getSceneX() + xOffset);
            setY(event.getSceneY() + yOffset);
        });

        // 3. 鼠标释放
        root.setOnMouseReleased(event -> {
            root.setCursor(Cursor.DEFAULT);
        });

    }

}
