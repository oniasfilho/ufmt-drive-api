package io.oniasfilho.ufmtdrive.controller.impl;

import io.oniasfilho.ufmtdrive.controller.UserController;
import io.oniasfilho.ufmtdrive.entity.User;
import io.oniasfilho.ufmtdrive.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class UserControllerImpl implements UserController {

    UserService service;

    public UserControllerImpl(UserService service) {
        this.service = service;
    }

    @GetMapping("/api/user")
    public List<User> listAllUsers() {
        return service.listAllUsers();
    }
}
