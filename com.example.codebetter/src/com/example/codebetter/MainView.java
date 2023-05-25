package com.example.codebetter;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.example.codebetter.contentprovider.ElementContentProvider;
import com.example.codebetter.labelprovider.ElementLabelProvider;
import com.example.codebetter.model.Element;
import com.example.codebetter.model.ElementStore;
import com.example.codebetter.model.Project;

public class MainView extends ViewPart {

    private TreeViewer viewer;

    @Override
    public void createPartControl(Composite parent) {
        viewer = new TreeViewer(parent);
        viewer.setContentProvider(new ElementContentProvider());
        viewer.setLabelProvider(new ElementLabelProvider());
        viewer.setInput(new ElementStore());
        viewer.expandAll();
    }

    @Override
    public void setFocus() {
        viewer.getControl().setFocus();
    }

    public void renameElement() {
        IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
        if (selection.isEmpty()) {
            return;
        }
        Object element = selection.getFirstElement();
        if (!(element instanceof Element)) {
            return;
        }
        Element e = (Element) element;

        InputDialog dialog = new InputDialog(viewer.getControl().getShell(), "Rename Element", "Enter new name for element:", e.getName(), null);
        if (dialog.open() == InputDialog.OK) {
            e.setName(dialog.getValue());
            viewer.refresh(e);
        }
    }

    public void checkDuplication() {
        IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
        if (selection.isEmpty()) {
            return;
        }
        Object element = selection.getFirstElement();
        if (!(element instanceof Element)) {
            return;
        }
        Element e = (Element) element;

        boolean duplicated = false;
        for (Element other : e.getProject().getElements()) {
            if (other != e && other.getName().equals(e.getName())) {
                duplicated = true;
                break;
            }
        }

        if (duplicated) {
            MessageDialog.openInformation(viewer.getControl().getShell(), "Duplicate Element", "The element \"" + e.getName() + "\" is duplicated.");
        } else {
            MessageDialog.openInformation(viewer.getControl().getShell(), "No Duplicate Element", "The element \"" + e.getName() + "\" is not duplicated.");
        }
    }

    public void extractMethod() {
        IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
        if (selection.isEmpty()) {
            return;
        }
        Object element = selection.getFirstElement();
        if (!(element instanceof Element)) {
            return;
        }
        Element e = (Element) element;

        String selectedCode = e.getCode();

        String methodName = "extractMethod";
        int start = selectedCode.indexOf("public");
        int end = selectedCode.lastIndexOf("}");
        if (start == -1 || end == -1) {
            return;
        }
        String methodBody = selectedCode.substring(start, end + 1);

        e.getProject().addMethod(methodName, methodBody);

        viewer.refresh(e);
    }
}