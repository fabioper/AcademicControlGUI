package br.edu.infnet.ui.desktop.controllers;

import br.edu.infnet.domain.entities.Student;
import br.edu.infnet.domain.interfaces.Repository;
import br.edu.infnet.infrastructure.StudentsRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.regex.Pattern;

public class RegisterStudent {
    private final Repository<Student> studentsRepository = StudentsRepository.getInstance();

    @FXML
    private TextField nameField;

    @FXML
    private TextField firstGradeField;

    @FXML
    private TextField secondGradeField;

    @FXML
    private Button confirmButton;

    @FXML
    private Label errorMessage;


    @FXML
    void registerStudent() {
        var stage = (Stage) confirmButton.getScene().getWindow();

        if (isValidForm()) {
            studentsRepository.add(createStudentFromFormInput());
            stage.close();
        } else {
            errorMessage.setText("Valores não válidos.");
        }
    }

    private boolean isValidForm() {
        var firstGradeValue = firstGradeField.getText();
        var secondGraveValue = secondGradeField.getText();
        return validateDouble(firstGradeValue) && validateDouble(secondGraveValue);
    }

    private Student createStudentFromFormInput() {
        var name = nameField.getText();
        var firstGrade = Double.parseDouble(firstGradeField.getText());
        var secondGrade = Double.parseDouble(secondGradeField.getText());
        return new Student(name, firstGrade, secondGrade);
    }

    private boolean validateDouble(String firstGradeValue) {
        var DOUBLE_PATTERN = "[0-9]+(\\.)?[0-9]*";
        return Pattern.matches(DOUBLE_PATTERN, firstGradeValue);
    }
}
