package io.oniasfilho.ufmtdrive.controller.impl;

import io.oniasfilho.ufmtdrive.controller.UserController;
import io.oniasfilho.ufmtdrive.dto.UserCreateReqDTO;
import io.oniasfilho.ufmtdrive.dto.UserReqDTO;
import io.oniasfilho.ufmtdrive.dto.UserRespDTO;
import io.oniasfilho.ufmtdrive.dto.UserRespWithoutNotesDTO;
import io.oniasfilho.ufmtdrive.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UserControllerImpl implements UserController {

    UserService service;

    public UserControllerImpl(UserService service) {
        this.service = service;
    }

    @GetMapping("/api/user")
    public List<UserRespDTO> listAllUsers() {
        return service.listAllUsers();
    }

    @PostMapping("/api/user")
    public void createUser(@RequestBody UserCreateReqDTO dto) {
        service.createUser(dto);
    }

    @PutMapping("/api/user")
    public UserRespWithoutNotesDTO updateUser(@RequestBody UserReqDTO dto){
        return service.updateUser(dto);
    }

    @DeleteMapping("api/user/{id}")
    public Long deleteUser(@PathVariable(value="id") Long id) {
        return service.deleteUserById(id);
    }
}
