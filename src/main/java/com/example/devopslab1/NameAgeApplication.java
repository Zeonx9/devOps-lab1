package com.example.devopslab1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import com.example.devopslab1.view.ViewController;

import java.io.IOException;
import java.util.Objects;

public class NameAgeApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ViewController.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        ViewController controller = fxmlLoader.getController();
        controller.init();

        stage.setTitle("Your Name, Age & Gender!");
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("lab3-icon.png"))));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}