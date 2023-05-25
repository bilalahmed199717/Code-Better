package com.example.codebetter.action;

import java.util.Scanner;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

import com.example.codebetter.model.ExtractMethodData;
import com.example.codebetter.model.Method;

public class ExtractMethod {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Get the name of the new method.
            System.out.println("Enter a name for the new method:");
            String methodName = scanner.nextLine();

            // Get the selected code.
            System.out.println("Enter the code to extract:");
            String selectedCode = scanner.nextLine();

            // Create a new ExtractMethodData object.
            ExtractMethodData data = new ExtractMethodData();
            data.setMethodName(methodName);
            data.addSelectedLine(selectedCode);

            // Extract the method.
            Method method = extractMethod(data);

            // Display the method declaration and body in a message dialog.
            String message = "The method declaration is: " + method.getName() + "\n\n" + method.getDeclaration() + "\n\n"
                    + "The method body is:\n\n" + method.getBody();
            MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Extract Method", message);
        }
    }

    public static Method extractMethod(ExtractMethodData data) {
        // Create a new method declaration.
        String methodDeclaration = "public void " + data.getMethodName() + "() {";

        // Add the body of the method.
        methodDeclaration += data.getSelectedCode();

        // Add the closing brace.
        methodDeclaration += "}";

        // Create a new method object.
        Method method = new Method(data.getMethodName(), methodDeclaration, data.getSelectedCode());

        // Return the method.
        return method;
    }
}
