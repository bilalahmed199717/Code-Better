package com.example.codebetter.handlers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import com.example.codebetter.model.Element;

public class CheckDuplicationHandler extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        // Get the selected elements.
        ISelection selection = HandlerUtil.getCurrentSelection(event);
        if (selection instanceof IStructuredSelection) {
            IStructuredSelection structuredSelection = (IStructuredSelection) selection;
            Object[] objs = structuredSelection.toArray();
            if (objs != null && objs.length > 0) {
                // Check the duplication of the elements.
                Set<Element> elements = new HashSet<>();
                for (Object obj : objs) {
                    if (obj instanceof Element) {
                        elements.add((Element) obj);
                    }
                }
                if (elements.size() < objs.length) {
                    System.out.println("The elements are duplicated: " + Arrays.toString(objs));
                }
            }
        }

        return null;
    }
}
