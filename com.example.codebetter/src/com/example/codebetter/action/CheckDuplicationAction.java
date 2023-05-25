package com.example.codebetter.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import java.util.HashSet;
import java.util.Set;
import com.example.codebetter.model.File;
import com.example.codebetter.model.Project;

public class CheckDuplicationAction extends Action {

    private TreeViewer treeViewer;

    public CheckDuplicationAction(TreeViewer treeViewer) {
        this.treeViewer = treeViewer;
        setText("Check Duplication");
        setToolTipText("Check for duplicated code");
        setEnabled(false);
    }

    @Override
    public void run() {
        ISelection selection = treeViewer.getSelection();
        if (selection != null && selection instanceof IStructuredSelection) {
            IStructuredSelection structuredSelection = (IStructuredSelection) selection;
            Object[] selectedItems = structuredSelection.toArray();
            Set<File> filesToCheck = new HashSet<>();
            for (Object item : selectedItems) {
                if (item instanceof Project) {
                    Project project = (Project) item;
                    filesToCheck.addAll(project.getAllFiles());
                } else if (item instanceof File) {
                    File file = (File) item;
                    filesToCheck.add(file);
                }
            }
            if (!filesToCheck.isEmpty()) {
                DirectoryDialog dialog = new DirectoryDialog(Display.getDefault().getActiveShell(), SWT.OPEN);
                dialog.setText("Select directory for duplicated code search");
                String directoryPath = dialog.open();
                if (directoryPath != null) {
                    // Perform the check here using the filesToCheck and the selected directory
                    MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Check Duplication",
                            "Checking duplication for " + filesToCheck.size() + " file(s) in directory: " + directoryPath);
                }
            }
        }
    }
}
