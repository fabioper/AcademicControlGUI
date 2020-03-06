package br.edu.infnet.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {
    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/Initial.fxml"));
        var scene = new Scene(root, 562, 267);

        primaryStage.setTitle("Academic Control");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
