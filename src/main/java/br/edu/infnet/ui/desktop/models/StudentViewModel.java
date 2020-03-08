package br.edu.infnet.ui.desktop.models;

import java.text.DecimalFormat;

public class StudentViewModel {
    private String name;
    private String firstGrade;
    private String secondGrade;
    private String average;
    private String result;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstGrade() {
        return firstGrade;
    }

    public void setFirstGrade(double firstGrade) {
        this.firstGrade = format(firstGrade);
    }

    public String getSecondGrade() {
        return secondGrade;
    }

    public void setSecondGrade(double secondGrade) {
        this.secondGrade = format(secondGrade);
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = format(average);
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    private String format(double number) {
        var formatter = new DecimalFormat("#.00");
        return formatter.format(number);
    }
}
