package com.examenblanc.azizataboubiexamenblanc.Services;

import com.examenblanc.azizataboubiexamenblanc.Repos.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ISprintServiceIMP implements ISprintService {
    @Autowired
    SprintRepository sprintRepository;
}
