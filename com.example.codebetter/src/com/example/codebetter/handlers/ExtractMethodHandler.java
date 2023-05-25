package com.example.codebetter.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.services.IServiceLocator;

import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;

import com.example.codebetter.model.File;
import com.example.codebetter.model.Project;

public class ExtractMethodHandler extends AbstractHandler implements ISelectionListener {

    private IHandlerActivation activation;
    private IServiceLocator locator;

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        // Get the selection from the event.
        ISelection selection = HandlerUtil.getCurrentSelection(event);

        if (selection instanceof IStructuredSelection) {
            Object firstElement = ((IStructuredSelection) selection).getFirstElement();
            if (firstElement instanceof Project) {
                // TODO: Handle project extraction
            } else if (firstElement instanceof File) {
                // TODO: Handle file extraction
            }
        }

        // Return null.
        return null;
    }

    @Override
    public void selectionChanged(IWorkbenchPart part, ISelection selection) {
        if (selection instanceof IStructuredSelection) {
            Object firstElement = ((IStructuredSelection) selection).getFirstElement();
            if (firstElement instanceof Project) {
                // TODO: Handle project extraction
            } else if (firstElement instanceof File) {
                // TODO: Handle file extraction
            }
        }
    }

    @Override
    public void dispose() {
        IHandlerService handlerService = (IHandlerService) locator.getService(IHandlerService.class);
        handlerService.deactivateHandler(activation);
    }

    @Override
    public void setEnabled(Object evaluationContext) {
        // No-op
    }

    public void init(IServiceLocator locator, IHandlerService handlerService) {
        this.locator = locator;
        activation = handlerService.activateHandler("com.example.codebetter.command.extractMethod", this);
    }
}
