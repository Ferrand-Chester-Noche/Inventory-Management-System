package com.inventory.restaurant;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Restaurant extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Restaurant.class.getResource("LandingPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 500);
        stage.setResizable(false);
        stage.setTitle("Restaurant");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}