package io.oniasfilho.ufmtdrive.controller;

import io.oniasfilho.ufmtdrive.dto.UserCreateReqDTO;
import io.oniasfilho.ufmtdrive.dto.UserReqDTO;
import io.oniasfilho.ufmtdrive.dto.UserRespDTO;
import io.oniasfilho.ufmtdrive.dto.UserRespWithoutNotesDTO;

import java.util.List;

public interface UserController {
    public List<UserRespDTO> listAllUsers();
    public void createUser(UserCreateReqDTO dto);
    public UserRespWithoutNotesDTO updateUser(UserReqDTO dto);
    public Long deleteUser(Long id);
}
