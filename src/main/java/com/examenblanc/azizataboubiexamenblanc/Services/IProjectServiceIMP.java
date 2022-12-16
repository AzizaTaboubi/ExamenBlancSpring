package com.examenblanc.azizataboubiexamenblanc.Services;

import com.examenblanc.azizataboubiexamenblanc.Entities.Project;
import com.examenblanc.azizataboubiexamenblanc.Entities.Role;
import com.examenblanc.azizataboubiexamenblanc.Entities.Sprint;
import com.examenblanc.azizataboubiexamenblanc.Entities.User;
import com.examenblanc.azizataboubiexamenblanc.Repos.ProjectRepository;
import com.examenblanc.azizataboubiexamenblanc.Repos.SprintRepository;
import com.examenblanc.azizataboubiexamenblanc.Repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IProjectServiceIMP implements IProjectService{
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    SprintRepository sprintRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public Project addProject(Project project) {

        Sprint sprint = new Sprint();
       Sprint s = sprintRepository.save(sprint);
        List<Sprint> sprints = new ArrayList<Sprint>();
        sprints.add(sprint);
        return projectRepository.save(project);
    }

    public void assignProjectToUser(int projectId, int userId) {

            User user = userRepository.findById(userId).get();
            Project project = projectRepository.findById(projectId).get();
            if ((user != null) && (project != null)) {
                project.setIntervenants((List<User>) user);

            }
        }

    @Override
    public void assignProjectToClient(int projectId, String firstName, String lastName) {
        List<Project> projects = (List<Project>) userRepository.findByFirstnameAndLastname(firstName, lastName).getProjects();
        Project project = projectRepository.findById(projectId).get();
        projects.add(project);

    }

    @Override
    public List<Project> getAllCurrentProject() {
        return projectRepository.findProjectsBySprintsAfter();
    }

    @Override
    public List<Project> getProjectsByScrumMaster(String fName, String lName) {
        List<Project> projects = (List<Project>) userRepository.findByRoleAAndFirstnameAndLastname(Role.SCRUM_MASTER, fName, lName).get();
        return projects;
    }
}

