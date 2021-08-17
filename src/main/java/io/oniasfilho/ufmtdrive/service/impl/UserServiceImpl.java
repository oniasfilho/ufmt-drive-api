package io.oniasfilho.ufmtdrive.service.impl;

import io.oniasfilho.ufmtdrive.entity.User;
import io.oniasfilho.ufmtdrive.repository.UserRepository;
import io.oniasfilho.ufmtdrive.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<User> listAllUsers() {
        List<User> users = new ArrayList<>();
        repo.findAll().forEach(users::add);
        return users;
    }
}
