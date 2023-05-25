package com.example.codebetter.view;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class ElementView extends ViewPart {
    private TreeViewer viewer;

    public ElementView() {
        // constructor
    }

    @Override
    public void createPartControl(Composite parent) {
        // implementation
    }

    @Override
    public void setFocus() {
        // implementation
    }

    public TreeViewer getViewer() {
        return viewer;
    }

}
