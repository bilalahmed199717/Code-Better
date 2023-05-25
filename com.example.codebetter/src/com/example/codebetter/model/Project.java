package com.example.codebetter.model;

import java.util.ArrayList;
import java.util.List;

public class Project {

    private String name;
    private List<File> elements = new ArrayList<>();

    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<File> getElements() {
        return elements;
    }

    public void addElement(File element) {
        elements.add(element);
    }

    public void removeElement(File element) {
        elements.remove(element);
    }

    public void addMethod(String methodName, String methodBody) {
        throw new IllegalArgumentException("The method addMethod(String methodName, String methodBody) in the type Project is not applicable for the arguments (Method).");
    }

    public List<File> getAllFiles() {
        List<File> allFiles = new ArrayList<>();
        for (File element : elements) {
            allFiles.add(element);
        }
        return allFiles;
    }
}
