package com.example.codebetter.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class File {

    private String fileName;
    private String code;

    public File(String fileName) throws IOException {
        this.fileName = fileName;
        this.code = Files.readString(Paths.get(fileName));
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void save() throws IOException {
        Files.writeString(Paths.get(fileName), code);
    }
}
