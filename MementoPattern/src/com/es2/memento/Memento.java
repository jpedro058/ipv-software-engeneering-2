package com.es2.memento;

public class Memento extends Object {
    private final java.util.ArrayList<String> studentNames;

    public Memento(java.util.ArrayList<java.lang.String> studentNames) {
        this.studentNames = studentNames;
    }

    public java.util.ArrayList<java.lang.String> getState() {
        return studentNames;
    }
}