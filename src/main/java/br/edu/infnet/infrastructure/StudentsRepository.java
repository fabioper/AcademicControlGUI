package br.edu.infnet.infrastructure;

import br.edu.infnet.data.ConnectionFactory;
import br.edu.infnet.domain.entities.Student;
import br.edu.infnet.domain.interfaces.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class StudentsRepository implements Repository<Student> {
    private Collection<Student> students;
    private static StudentsRepository _instance;

    private StudentsRepository() {
        students = new ArrayList<>();
    }

    public static StudentsRepository getInstance() {
        if (_instance != null) return _instance;
        _instance = new StudentsRepository();
        return _instance;
    }

    @Override
    public Collection<Student> getAll() {
        try (var conn = ConnectionFactory.connect()) {
            var queryStatement = "SELECT name, firstGrade, secondGrade FROM students";
            try (var query = conn.prepareStatement(queryStatement)) {
                parseStudents(query);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    private void parseStudents(PreparedStatement query) throws SQLException {
        students.clear();
        var result = query.executeQuery();
        while (result.next()) {
            var student = new Student(
                    result.getString("name"),
                    result.getDouble("firstGrade"),
                    result.getDouble("secondGrade")
            );
            students.add(student);
        }
    }

    @Override
    public Student getById(UUID id) {
        return null;
    }

    @Override
    public void add(Student student) {
        try (var conn = ConnectionFactory.connect()) {
            var sql = "INSERT INTO students (name, firstGrade, secondGrade) VALUES (?, ?, ?)";
            try (var statement = conn.prepareStatement(sql)) {
                statement.setString(1, student.getName());
                statement.setDouble(2, student.getFirstGrade());
                statement.setDouble(3, student.getSecondGrade());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getSize() {
        var result = 0;
        try (var conn = ConnectionFactory.connect()) {
            try (var statement = conn.prepareStatement("SELECT COUNT(name) FROM students")) {
                var queryResult = statement.executeQuery();
                result = queryResult.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void addAll(Student... entities) {
        for (var student : entities) add(student);
    }

    @Override
    public void clear() {
        students.clear();
    }
}
