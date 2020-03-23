package br.edu.infnet.infrastructure;

import br.edu.infnet.domain.entities.Student;
import br.edu.infnet.domain.interfaces.Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentsRepositoryTest {
    private static Repository<Student> repository;

    @BeforeEach
    void setUp() {
        repository = StudentsRepository.getInstance();
        repository.clear();
    }

    @Test
    void shouldAddStudent() {
        Student student = new Student("Student", 2.2, 9.7);
        repository.add(student);
        assertEquals(student, repository.getById(student.getId()));
    }

    @Test
    void shouldReturnNumberOfRegisteredStudents() {
        addStudents();
        assertEquals(4, repository.getSize());
    }

    private void addStudents() {
        repository.addAll(
                new T[]{new Student("Student", 5.7, 7.1), new Student("Student2", 9, 8.1), new Student("Student3", 7.5, 10), new Student("Student", 2.2, 9.7)});
    }
}