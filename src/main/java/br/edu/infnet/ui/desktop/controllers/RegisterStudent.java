package br.edu.infnet.ui.desktop.controllers;

import br.edu.infnet.domain.entities.Student;
import br.edu.infnet.domain.interfaces.Repository;
import br.edu.infnet.infrastructure.StudentsRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
    void registerStudent(ActionEvent event) {
        var name = nameField.getText();
        var firstGrade = Double.parseDouble(firstGradeField.getText());
        var secondGrade = Double.parseDouble(secondGradeField.getText());
        studentsRepository.add(new Student(name, firstGrade, secondGrade));
    }
}
