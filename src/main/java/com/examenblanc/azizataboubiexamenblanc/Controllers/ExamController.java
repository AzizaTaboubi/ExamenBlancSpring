package com.examenblanc.azizataboubiexamenblanc.Controllers;


import com.examenblanc.azizataboubiexamenblanc.Entities.Project;
import com.examenblanc.azizataboubiexamenblanc.Entities.User;
import com.examenblanc.azizataboubiexamenblanc.Services.IProjectService;
import com.examenblanc.azizataboubiexamenblanc.Services.ISprintService;
import com.examenblanc.azizataboubiexamenblanc.Services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    IUserService iUserService;
    @Autowired
    ISprintService iSprintService;
    @Autowired
    IProjectService iProjectService;

    @GetMapping("/addUser")
    public User addUser (@RequestBody User user)
    {
        return  iUserService.addUser(user);
    }

    @GetMapping("/assigntoUser/{projectid}/{userid}")
    public void assignProjectToUser(@PathVariable(value ="projectid")int projectId, @PathVariable(value ="userid")int userId){
        iProjectService.assignProjectToUser(projectId, userId);
    }
    @GetMapping("/assigntoClient/{projectid}/{firstname}/{lastname}")
    public void assignProjectToClient(@PathVariable(value ="projectid")int projectId, @PathVariable(value ="firstname")String firstName,@PathVariable(value ="lastname")String lastName){
        iProjectService.assignProjectToClient(projectId, firstName, lastName);
    }

    @GetMapping("/showCurrentProjects")
    public List<Project> Current()
    {
        return  iProjectService.getAllCurrentProject();
    }

    @GetMapping("/showProjectsByScrumMaster/{firstname}/{lastname}")
    public List<Project> scrumMaster(@PathVariable(value ="firstname")String fName,@PathVariable(value ="lastname")String lName)
    {
        return  iProjectService.getProjectsByScrumMaster(fName, lName)
    }


}
