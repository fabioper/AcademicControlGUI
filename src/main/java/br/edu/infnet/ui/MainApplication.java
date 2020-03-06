package br.edu.infnet.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {
    private final int initialWidth = 500;
    private final int initialHeight = 300;

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/Initial.fxml"));
        primaryStage.setTitle("Academic Control");
        primaryStage.setScene(new Scene(root, initialWidth, initialHeight));
        primaryStage.show();
    }
}
