package com.examenblanc.azizataboubiexamenblanc.Services;

import com.examenblanc.azizataboubiexamenblanc.Entities.User;
import com.examenblanc.azizataboubiexamenblanc.Repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IUserServiceIMP implements IUserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }




}
