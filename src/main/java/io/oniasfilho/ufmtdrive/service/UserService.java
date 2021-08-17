package io.oniasfilho.ufmtdrive.service;

import io.oniasfilho.ufmtdrive.dto.UserReqDTO;
import io.oniasfilho.ufmtdrive.dto.UserRespDTO;
import io.oniasfilho.ufmtdrive.dto.UserRespWithoutNotesDTO;

import java.util.List;

public interface UserService {

    public List<UserRespDTO> listAllUsers();

    UserRespWithoutNotesDTO createUser(UserReqDTO dto);

    UserRespWithoutNotesDTO updateUser(UserReqDTO dto);

    Long deleteUserById(Long id);
}
