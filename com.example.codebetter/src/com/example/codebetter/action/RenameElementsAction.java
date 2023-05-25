package com.example.codebetter.action;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import com.example.codebetter.model.Element;
import com.example.codebetter.model.ElementStore;
import com.example.codebetter.view.ElementView;

public class RenameElementsAction extends Action {

    private ISelectionProvider selectionProvider;

    public RenameElementsAction(ISelectionProvider selectionProvider) {
        super("Rename Element...");
        this.selectionProvider = selectionProvider;
    }

    @Override
    public void run() {
        ISelection selection = selectionProvider.getSelection();
        if (selection instanceof IStructuredSelection) {
            List<?> selectionList = ((IStructuredSelection) selection).toList();
            List<Element> elements = new ArrayList<>();
            for (Object element : selectionList) {
                if (element instanceof Element) {
                    elements.add((Element) element);
                }
            }
            if (!elements.isEmpty()) {
                InputDialog inputDialog = new InputDialog(
                        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                        "Rename Elements", "Enter new name for element:",
                        elements.get(0).getName(), null);

                if (inputDialog.open() == InputDialog.OK) {
                    String newName = inputDialog.getValue();
                    for (Element element : elements) {
                        if (!newName.equals(element.getName())) {
                            ElementStore.getInstance().renameElement(element.getName(), newName);
                        }
                    }

                    // Refresh the viewer to reflect the changes
                    IWorkbenchPart workbenchPart = PlatformUI.getWorkbench()
                            .getActiveWorkbenchWindow().getActivePage().getActivePart();
                    if (workbenchPart instanceof ElementView) {
                        ElementView elementView = (ElementView) workbenchPart;
                        TreeViewer treeViewer = (TreeViewer) elementView.getViewer();
                        treeViewer.refresh();
                    }
                }
            }
        }
    }
}
