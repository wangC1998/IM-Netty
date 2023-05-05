package com.wc.learn;

import com.wc.learn.view.Login;
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
        Login login = new Login();
        login.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
