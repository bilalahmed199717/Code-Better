package com.example.codebetter.model;

public class Element {

    private String name;
    private String signature;
    private String code;
    private Project project;

    public Element(String name, String signature, String code, Project project) {
        this.name = name;
        this.signature = signature;
        this.code = code;
        this.project = project;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "Element [name=" + name + ", signature=" + signature + ", code=" + code + ", project=" + project.getName() + "]";
    }
}
