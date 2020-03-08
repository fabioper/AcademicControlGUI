package br.edu.infnet.ui.desktop.models;

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

    public void setFirstGrade(String firstGrade) {
        this.firstGrade = firstGrade;
    }

    public String getSecondGrade() {
        return secondGrade;
    }

    public void setSecondGrade(String secondGrade) {
        this.secondGrade = secondGrade;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
