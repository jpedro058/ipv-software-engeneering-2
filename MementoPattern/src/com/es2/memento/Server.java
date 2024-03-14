package com.es2.memento;

public class Server extends Object{
    private java.util.ArrayList<String> studentNames;

    public Server() {
        studentNames = new java.util.ArrayList<>();
    }

    public void addStudent(String studentName) throws ExistingStudentException {
        if (studentNames.contains(studentName)) {
            throw new ExistingStudentException("Student already exists: " + studentName);
        }
        studentNames.add(studentName);
    }

    public Memento backup() {
        return new Memento(new java.util.ArrayList<>(studentNames));
    }

    public void restore(Memento state) {
        studentNames = state.getState();
    }

    public java.util.ArrayList<String> getStudentNames() {
        return new java.util.ArrayList<>(studentNames);
    }

}
