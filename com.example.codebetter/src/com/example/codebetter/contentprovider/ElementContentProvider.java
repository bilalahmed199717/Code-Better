package com.example.codebetter.contentprovider;

import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class ElementContentProvider implements IStructuredContentProvider {

    @Override
    public Object[] getElements(Object inputElement) {
        if (inputElement instanceof List) {
            // Get the list of elements from the input element.
            List<?> elementList = (List<?>) inputElement;

            // Return the list of elements.
            return elementList.toArray();
        }
        return new Object[0];
    }

    @Override
    public void dispose() {
        // Nothing to do.
    }

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        // Nothing to do.
    }
}
