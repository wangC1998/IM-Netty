package com.wc.learn;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author wc
 */
public class MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/demo/demo.fxml"));
        primaryStage.setTitle("Hello World!!!!!!!");
        primaryStage.setScene(new Scene(root, 800, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
