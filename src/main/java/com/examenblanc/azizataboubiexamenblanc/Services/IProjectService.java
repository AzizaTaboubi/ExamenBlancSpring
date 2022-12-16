package com.examenblanc.azizataboubiexamenblanc.Services;

import com.examenblanc.azizataboubiexamenblanc.Entities.Project;

import java.util.List;

public interface IProjectService {
    Project addProject(Project project);
    void assignProjectToUser(int projectId, int userId);
    void assignProjectToClient(int projectId, String firstname, String lastname);
    List<Project>getAllCurrentProject();
    List<Project>getProjectsByScrumMaster(String fName, String lName);
}
