package br.edu.infnet.ui.desktop.controllers;

import br.edu.infnet.domain.entities.Student;
import br.edu.infnet.domain.interfaces.Repository;
import br.edu.infnet.infrastructure.StudentsRepository;
import br.edu.infnet.infrastructure.StudentsRepositoryInMemory;
import br.edu.infnet.ui.desktop.models.StudentViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Initial implements Initializable {
    private Repository<Student> studentsRepository = StudentsRepository.getInstance();

    @FXML
    private TableView<StudentViewModel> studentsTable;

    @FXML
    private TableColumn<StudentViewModel, String> nameColumn;

    @FXML
    private TableColumn<StudentViewModel, String> firstGradeColumn;

    @FXML
    private TableColumn<StudentViewModel, String> secondGradeColumn;

    @FXML
    private TableColumn<StudentViewModel, String> averageColumn;

    @FXML
    private TableColumn<StudentViewModel, String> resultColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setColumnsProperties();
        studentsTable.setItems(getStudentViewModels());
    }

    @FXML
    void openRegisterStudentScene(ActionEvent event) throws IOException {
        var stage = new Stage();
        stage.setTitle("Registar estudante");
        stage.initModality(Modality.APPLICATION_MODAL);
        Parent root = FXMLLoader.load(getClass().getResource("/views/RegisterStudent.fxml"));
        var scene = new Scene(root, 320, 290);
        stage.setScene(scene);
        stage.showAndWait();
        studentsTable.setItems(getStudentViewModels());
    }

    private void setColumnsProperties() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        firstGradeColumn.setCellValueFactory(new PropertyValueFactory<>("firstGrade"));
        secondGradeColumn.setCellValueFactory(new PropertyValueFactory<>("secondGrade"));
        averageColumn.setCellValueFactory(new PropertyValueFactory<>("average"));
        resultColumn.setCellValueFactory(new PropertyValueFactory<>("result"));
    }

    private ObservableList<StudentViewModel> getStudentViewModels() {
        var students = studentsRepository.getAll();
        ObservableList<StudentViewModel> studentsList = FXCollections.observableArrayList();
        students.stream().map(this::mapFieldsFrom).forEach(studentsList::add);
        return studentsList;
    }

    private StudentViewModel mapFieldsFrom(Student student) {
        return new StudentViewModel() {
            {
                setName(student.getName());
                setFirstGrade(student.getFirstGrade());
                setSecondGrade(student.getSecondGrade());
                setAverage(student.getAverageGrade());
                setResult(student.getResult().getDescription());
            }
        };
    }
}
