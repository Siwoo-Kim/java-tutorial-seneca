package com.siwoo.entity;

import java.util.Arrays;

public class Student {
    
    private enum Grade {
        A, B, C, D, E, F
    }
    
    private final String school;
    private final String name;
    private String program;
    private Grade[] grades = new Grade[6];
    private boolean graduated;

    public Student(String school, String name, String program, boolean graduated) {
        this.school = school;
        this.name = name;
        this.program = program;
        this.graduated = graduated;
    }

    public String getSchool() {
        return school;
    }

    public String getName() {
        return name;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public void setGradeOf(int semester, Grade grade) {
        if (semester < 0 || semester > 6) 
            throw new IllegalArgumentException();
        grades[semester-1] = grade;
    }

    public Grade getGradeOf(int semester) {
        if (semester < 0 || semester > 6)
            throw new IllegalArgumentException();
        return grades[semester-1];
    }

    public boolean isGraduated() {
        return graduated;
    }

    @Override
    public String toString() {
        return "Student{" +
                "school='" + school + '\'' +
                ", name='" + name + '\'' +
                ", program='" + program + '\'' +
                ", grades=" + Arrays.toString(grades) +
                ", graduated=" + graduated +
                '}';
    }

    public static void main(String[] args) {
        Student student = new Student("Seneca", "Hauen", "CPA", false);
        student.setGradeOf(1, Grade.A);
        student.setGradeOf(2, Grade.A);
        student.setGradeOf(3, Grade.B);
        System.out.println(student);
    }
}
