package com.example.codebetter.editor;

import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.part.EditorPart;

public class DocumentListener implements IDocumentListener {

    private final Display display;
    private final EditorPart editorPart;

    public DocumentListener(Display display, EditorPart editorPart) {
        this.display = display;
        this.editorPart = editorPart;
    }

    @Override
    public void documentChanged(DocumentEvent event) {
        // Handle document changes
        IDocument document = event.getDocument();
        if (document.getLength() > 0) {
            System.out.println("Document changed: " + document.get());
            display.asyncExec(() -> {
                editorPart.doSave(null);
            });
        }
    }

    @Override
    public void documentAboutToBeChanged(DocumentEvent event) {
        // Handle document changes
    }
}
