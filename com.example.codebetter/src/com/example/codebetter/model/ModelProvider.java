package com.example.codebetter.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.JavaCore;

public class ModelProvider {

    public List<Project> getProjects() throws CoreException {
        List<Project> projects = new ArrayList<>();
        IProject[] workspaceProjects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
        for (IProject project : workspaceProjects) {
            if (project.isOpen() && project.hasNature(JavaCore.NATURE_ID)) {
                projects.add(new Project(project));
            }
        }
        return projects;
    }
}
