package com.examenblanc.azizataboubiexamenblanc.Repos;

import com.examenblanc.azizataboubiexamenblanc.Entities.Role;
import com.examenblanc.azizataboubiexamenblanc.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByFirstnameAndLastname(String f, String l);
    public List<User> findByRoleAAndFirstnameAndLastname(Role role, String first, String last);
}
