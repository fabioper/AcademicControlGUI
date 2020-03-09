package br.edu.infnet.ui.desktop.components;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;

public class Modal {
    private final String title;

    public Modal(String stageTitle) {
        title = stageTitle;
    }

    public Stage open(URL templatePath) {
        var root = assignTemplateURL(templatePath);
        var scene = new Scene(root);
        return setUpModal(scene);
    }

    private Stage setUpModal(Scene scene) {
        var stage = new Stage();
        stage.setTitle(title);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        return stage;
    }

    private Parent assignTemplateURL(URL templatePath) {
        try {
            return FXMLLoader.load(templatePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
