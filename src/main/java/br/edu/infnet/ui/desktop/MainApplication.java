package br.edu.infnet.ui.desktop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {
    private final int initialWidth = 960;
    private final int initialHeight = 450;

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/Initial.fxml"));
        primaryStage.setTitle("Academic Control");
        Scene scene = new Scene(root, initialWidth, initialHeight);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
