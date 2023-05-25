package com.example.codebetter.model;

import java.util.HashMap;
import java.util.Map;

public class ElementStore {

	private static ElementStore instance;

	private Map<String, Element> elements = new HashMap<>();

	public ElementStore() {}

	public static ElementStore getInstance() {
	    if (instance == null) {
	        instance = new ElementStore();
	    }
	    return instance;
	}

	public void addElement(String name, Element element) {
	    elements.put(name, element);
	}

	public Element getElement(String name) {
	    return elements.get(name);
	}

	public void removeElement(String name) {
	    elements.remove(name);
	}

	public void renameElement(String oldName, String newName) {
	    Element element = elements.remove(oldName);
	    element.setName(newName);
	    elements.put(newName, element);
	}

	public Map<String, Element> getElements() {
	    return elements;
	}

	public void listElements() {
	    for (Element element : elements.values()) {
	        System.out.println(element);
	    }
	}

}
