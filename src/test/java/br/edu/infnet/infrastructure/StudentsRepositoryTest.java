package br.edu.infnet.infrastructure;

import br.edu.infnet.domain.entities.Student;
import br.edu.infnet.domain.helpers.Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentsRepositoryTest {
    private static Repository<Student> repository;

    @BeforeEach
    void setUp() {
        repository = StudentsRepository.getInstance();
        Student student = new Student("Student", 5.7, 7.1);
        Student student1 = new Student("Student2", 9, 8.1);
        Student student2 = new Student("Student3", 7.5, 10);
        repository.add(student);
        repository.add(student1);
        repository.add(student2);
    }

    @Test
    void shouldAddStudent() {
        Student student = new Student("Student", 2.2, 9.7);
        repository.add(student);
        assertEquals(student, repository.getById(student.getId()));
    }

    @Test
    void shouldReturnNumberOfRegisteredStudents() {
        Student student = new Student("Student", 2.2, 9.7);
        repository.add(student);
        assertEquals(4, repository.getSize());
    }
}