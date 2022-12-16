package com.examenblanc.azizataboubiexamenblanc.Repos;

import com.examenblanc.azizataboubiexamenblanc.Entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
      public List<Project> findProjectsBySprintsAfter();

}
