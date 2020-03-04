package br.edu.infnet.domain.entities;

import br.edu.infnet.domain.helpers.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {
    private Student student;

    @BeforeEach
    void createStudent() {
        student = new Student("Random", 5.5, 8.4);
    }

    @Test
    void getAverageGrade() {
        assertEquals(6.95, student.getAverageGrade());
    }

    @Test
    @DisplayName("Student should be approved if average grade is greater than 7")
    void studentGetApproved() {
        Student approvedStudent = new Student("Approved Student", 7.5, 8);
        assertEquals(Result.PASSED, approvedStudent.getResult());
    }

    @Test
    @DisplayName("Student must take the final exam if his average is between 4 and 6")
    void studentMustTakeFinalExam() {
        Student finalExamStudent = new Student("Final Exam student", 5.1, 6.8);
        assertEquals(Result.FINAL_EXAM, finalExamStudent.getResult());
    }

    @Test
    @DisplayName("Student must fail if his average grade is less than 4")
    void studentMustFail() {
        Student failedStudent = new Student("Failed Student", 1.2, 3.4);
        assertEquals(Result.FAILED, failedStudent.getResult());
    }
}