package br.edu.infnet.infrastructure;

import br.edu.infnet.domain.entities.Student;
import br.edu.infnet.domain.helpers.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public final class StudentsRepository implements Repository<Student> {
    private Collection<Student> students;
    private static StudentsRepository _instance;

    private StudentsRepository() {
        this.students = new ArrayList<>();
    }

    public static StudentsRepository getInstance() {
        if (_instance != null) return _instance;
        return new StudentsRepository();
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
}
