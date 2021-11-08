package com.example.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("sample.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Epminer");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
        stage.setWidth(600);
        stage.setHeight(400);
        stage.setResizable(false);


    }



    public static void main(String[] args) {
        launch();
    }
}

