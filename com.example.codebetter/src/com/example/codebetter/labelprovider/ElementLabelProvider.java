package com.example.codebetter.labelprovider;

import org.eclipse.jface.viewers.LabelProvider;

import com.example.codebetter.model.Element;

public class ElementLabelProvider extends LabelProvider {

    @Override
    public String getText(Object element) {
        if (element instanceof Element) {
            return ((Element) element).getName();
        } else {
            return super.getText(element);
        }
    }
}
