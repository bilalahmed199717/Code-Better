package com.example.codebetter.model;

public class Method {

    private String name;
    private String declaration;
    private String body;

    public Method(String name, String declaration, String body) {
        this.name = name;
        this.declaration = declaration;
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeclaration() {
        return declaration;
    }

    public void setDeclaration(String declaration) {
        this.declaration = declaration;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
