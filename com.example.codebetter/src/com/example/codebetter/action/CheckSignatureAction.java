package com.example.codebetter.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Display;

import com.example.codebetter.model.Element;

public class CheckSignatureAction extends Action {

    private TreeViewer viewer;

    public CheckSignatureAction(TreeViewer viewer) {
        this.viewer = viewer;
        setText("Check Signature");
        setToolTipText("Check the signature of the selected element");
    }

    @Override
    public void run() {
        ISelection selection = viewer.getSelection();
        if (selection != null && selection instanceof IStructuredSelection) {
            Object obj = ((IStructuredSelection) selection).getFirstElement();

            if (obj instanceof Element) {
                Element element = (Element) obj;
                String signature = element.getSignature();

                if (signature != null) {
                    MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Element Signature", signature);
                } else {
                    MessageDialog.openError(Display.getDefault().getActiveShell(), "Element Signature", "This element has no signature");
                }
            }
        }
    }
}
