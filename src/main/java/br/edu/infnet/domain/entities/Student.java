package br.edu.infnet.domain.entities;

import br.edu.infnet.domain.enums.Result;

import java.util.UUID;

public class Student extends Entity {
    private String name;
    private double firstGrade;
    private double secondGrade;

    public Student(String name, double firstGrade, double secondGrade) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.firstGrade = firstGrade;
        this.secondGrade = secondGrade;
    }

    public String getName() {
        return name;
    }

    public double getFirstGrade() {
        return firstGrade;
    }

    public double getSecondGrade() {
        return secondGrade;
    }

    public double getAverageGrade() {
        return (firstGrade + secondGrade) / 2;
    }

    public Result getResult() {
        double average = getAverageGrade();
        int minimumToNotFail = 4;
        int minimumToPass = 7;

        if (average < minimumToNotFail)
            return Result.FAILED;
        else if (average >= minimumToNotFail && average < minimumToPass)
            return Result.FINAL_EXAM;

        return Result.PASSED;
    }
}
