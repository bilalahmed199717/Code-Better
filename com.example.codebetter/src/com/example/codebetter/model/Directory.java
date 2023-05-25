package com.example.codebetter.model;

import java.util.HashMap;
import java.util.Map;

public class Directory extends Element {

    private Map<String, Element> elements = new HashMap<>();

    public Directory(String name) {
        super(name, null, null, null);
    }

    public Directory(String name, Map<String, Element> elements) {
        super(name, null, null, null);
        this.elements = elements;
    }

    public Map<String, Element> getElements() {
        return elements;
    }

    public void setElements(Map<String, Element> elements) {
        this.elements = elements;
    }
}