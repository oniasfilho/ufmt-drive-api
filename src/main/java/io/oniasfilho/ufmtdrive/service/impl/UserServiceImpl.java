package io.oniasfilho.ufmtdrive.service.impl;

import io.oniasfilho.ufmtdrive.dto.*;
import io.oniasfilho.ufmtdrive.dto.util.DTOMapper;
import io.oniasfilho.ufmtdrive.entity.Address;
import io.oniasfilho.ufmtdrive.entity.Note;
import io.oniasfilho.ufmtdrive.entity.User;
import io.oniasfilho.ufmtdrive.repository.NoteRepository;
import io.oniasfilho.ufmtdrive.repository.UserRepository;
import io.oniasfilho.ufmtdrive.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    NoteRepository noteRepository;

    public UserServiceImpl(UserRepository repo, NoteRepository noteRepository) {
        this.userRepository = repo;
        this.noteRepository = noteRepository;
    }

    @Override
    public List<UserRespDTO> listAllUsers() {
        List<User> users = new ArrayList<>();
        List<UserRespDTO> usersDTO = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        users.forEach(user -> {
            usersDTO.add(DTOMapper.user2UserRespDTO(user));
        });

        usersDTO.forEach(dto -> {
            List<NoteRespUsersListDTO> noteDtos = new ArrayList<>();
            List<Note> notes = new ArrayList<>();
            notes = noteRepository.getNotesByUserId(dto.getId());
            notes.forEach(note ->{
                noteDtos.add(DTOMapper.note2NoteRespUsersListDTO(note));
            });
            dto.setNotas(noteDtos);
        });

        return usersDTO;
    }

    @Override
    public void createUser(UserCreateReqDTO dto) {
        User novo_usuario = new User();
        Address novo_endereco = new Address();

        novo_usuario.setUsername(dto.getUsername());
        novo_usuario.setPassword(dto.getPassword());
        novo_usuario.setFirst_name(dto.getFirst_name());
        novo_usuario.setLast_name(dto.getLast_name());

        novo_endereco.setStreet(dto.getAddress().getStreet());
        novo_endereco.setCity(dto.getAddress().getCity());
        novo_endereco.setState(dto.getAddress().getState());
        novo_endereco.setZip_code(dto.getAddress().getZip_code());

        novo_usuario.setAddress(novo_endereco);

        userRepository.save(novo_usuario);
    }

    @Override
    public UserRespWithoutNotesDTO updateUser(UserReqDTO dto) {
        User user = userRepository.findById(dto.getId()).get();
        user.setUsername(dto.getUsername());
        user.setFirst_name(dto.getFirst_name());
        user.setLast_name(dto.getLast_name());

        return DTOMapper.user2UserRespWithoutNotes(userRepository.save(user));
    }

    @Override
    public Long deleteUserById(Long id) {
        userRepository.deleteById(id);
        return id;
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
