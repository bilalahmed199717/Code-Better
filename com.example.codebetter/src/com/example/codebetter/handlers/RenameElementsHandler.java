package com.example.codebetter.handlers;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.handlers.HandlerUtil;

import com.example.codebetter.model.Element;

public class RenameElementsHandler extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        // Get the selected elements.
        ISelection selection = HandlerUtil.getCurrentSelection(event);
        if (selection instanceof IStructuredSelection) {
            IStructuredSelection structuredSelection = (IStructuredSelection) selection;
            Object[] objs = structuredSelection.toArray();
            if (objs != null && objs.length > 0) {
                // Rename the elements.
                for (Object obj : objs) {
                    if (obj instanceof Element) {
                        Element element = (Element) obj;
                        String newName = "newName"; // replace with new name
                        element.setName(newName);
                        System.out.println("The element is renamed to: " + newName);
                    }
                }
            }
        }

        return null;
    }
}
