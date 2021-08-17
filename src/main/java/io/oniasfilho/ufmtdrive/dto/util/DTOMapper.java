package io.oniasfilho.ufmtdrive.dto.util;

import io.oniasfilho.ufmtdrive.dto.*;
import io.oniasfilho.ufmtdrive.entity.Note;
import io.oniasfilho.ufmtdrive.entity.User;

import java.util.List;

public class DTOMapper {

    public static NoteReqDTO note2NoteReqDTO(Note note){
        NoteReqDTO dto = new NoteReqDTO(note.getNoteTitle(), note.getNoteDescription(), note.getUser().getId());
        return dto;
    }

    public static NoteRespDTO note2NoteRespDTO(Note note){
        NoteRespDTO dto = new NoteRespDTO(note.getNoteTitle(), note.getNoteDescription(), note.getUser().getId());
        return dto;
    }

    public static NoteRespUsersListDTO note2NoteRespUsersListDTO(Note note){
        NoteRespUsersListDTO dto = new NoteRespUsersListDTO(note.getNoteTitle(), note.getNoteDescription());
        return dto;
    }

    public static Note noteReqDTO2Note(NoteReqDTO dto){
        Note note = new Note();
        note.setNoteTitle(dto.getNote_title());
        note.setNoteDescription(dto.getNote_description());
        User user = new User();
        user.setId(dto.getUser_id());
        note.setUser(user);
        return note;
    }

    public static UserRespDTO user2UserRespDTO(User user){
      UserRespDTO dto = new UserRespDTO();
      dto.setId(user.getId());
      dto.setUsername(user.getUsername());
      dto.setFirst_name(user.getFirst_name());
      dto.setLast_name(user.getLast_name());

      return dto;
    }

    public static UserRespWithoutNotesDTO user2UserRespWithoutNotes(User user){
        UserRespWithoutNotesDTO dto = new UserRespWithoutNotesDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setFirst_name(user.getFirst_name());
        dto.setLast_name(user.getLast_name());

        return dto;
    }

    public static User userReqDTO2User(UserReqDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setFirst_name(dto.getFirst_name());
        user.setLast_name(dto.getLast_name());
        return user;
    }

//    private Long id;
//    private String username;
//    private String first_name;
//    private String last_name;
//    private List<NoteRespDTO> notas;
}
