package com.example.codebetter.model;

import java.util.ArrayList;
import java.util.List;

public class ExtractMethodData {

    private Project project;
    private File file;
    private List<String> selectedLines = new ArrayList<>();
    private String methodName;

    public ExtractMethodData() {
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public List<String> getSelectedLines() {
        return selectedLines;
    }

    public void addSelectedLine(String line) {
        selectedLines.add(line);
    }

    public void removeSelectedLine(String line) {
        selectedLines.remove(line);
    }

    public String getSelectedCode() {
        StringBuilder builder = new StringBuilder();
        for (String line : selectedLines) {
            builder.append(line).append("\n");
        }
        return builder.toString();
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
