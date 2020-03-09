package br.edu.infnet.infrastructure;

import br.edu.infnet.domain.entities.Student;
import br.edu.infnet.domain.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public final class StudentsRepositoryInMemory implements Repository<Student> {
    private Collection<Student> students;
    private static StudentsRepositoryInMemory _instance;

    private StudentsRepositoryInMemory() {
        this.students = new ArrayList<>();
    }

    public static StudentsRepositoryInMemory getInstance() {
        if (_instance != null) return _instance;
        _instance = new StudentsRepositoryInMemory();

        return _instance;
    }

    @Override
    public Collection<Student> getAll() {
        return students;
    }

    @Override
    public Student getById(UUID id) {
        for (Student student : this.students)
            if (student.getId() == id) return student;

        return null;
    }

    @Override
    public void add(Student student) {
        this.students.add(student);
    }

    @Override
    public int getSize() {
        return this.students.size();
    }

    @Override
    public void addAll(Student... students) {
        for (Student student : students) {
            this.students.add(student);
        }
    }

    @Override
    public void clear() {
        this.students.clear();
    }
}
