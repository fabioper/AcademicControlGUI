package br.edu.infnet.ui.desktop.controllers;

import br.edu.infnet.domain.entities.Student;
import br.edu.infnet.domain.interfaces.Repository;
import br.edu.infnet.infrastructure.StudentsRepository;
import br.edu.infnet.ui.desktop.models.StudentViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
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

    @FXML
    private Button registerStudentButton;

    @FXML
    private TableColumn<StudentViewModel, String> actionsColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setColumnsProperties();
        studentsTable.setItems(getStudentViewModels());
    }

    @FXML
    void openRegisterStudentScene(ActionEvent event) {
//        TODO: Open student registration window
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
        var studentsList = new ArrayList<StudentViewModel>();

        for (Student student : students)
            studentsList.add(this.mapFieldsFrom(student));

        return FXCollections.observableArrayList(studentsList);
    }

    private StudentViewModel mapFieldsFrom(Student student) {
        var vm = new StudentViewModel();
        vm.setName(student.getName());
        vm.setFirstGrade(String.valueOf(student.getFirstGrade()));
        vm.setSecondGrade(String.valueOf(student.getSecondGrade()));
        vm.setAverage(String.valueOf(student.getAverageGrade()));
        vm.setResult(String.valueOf(student.getResult()));
        return vm;
    }
}
