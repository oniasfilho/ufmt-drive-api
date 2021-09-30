package io.oniasfilho.ufmtdrive.controller.impl;

import io.oniasfilho.ufmtdrive.controller.NoteController;
import io.oniasfilho.ufmtdrive.dto.NoteReqDTO;
import io.oniasfilho.ufmtdrive.dto.NoteReqForUpdateDTO;
import io.oniasfilho.ufmtdrive.dto.NoteRespDTO;
import io.oniasfilho.ufmtdrive.dto.util.DTOMapper;
import io.oniasfilho.ufmtdrive.entity.Note;
import io.oniasfilho.ufmtdrive.entity.User;
import io.oniasfilho.ufmtdrive.service.NoteService;
import io.oniasfilho.ufmtdrive.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteControllerImpl implements NoteController {

    NoteService service;
    UserService userService;

    public NoteControllerImpl(NoteService service, UserService userService) {
        this.service = service;
        this.userService = userService;
    }

    @PostMapping("/api/note")
    public NoteRespDTO createNewNote(@RequestBody NoteReqDTO note, @RequestHeader (name="Authorization") String token) {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = (String) authentication.getPrincipal();
        User newUser = userService.findUserByUsername(username);
        NoteReqDTO comId = note;
        comId.setUser_id(newUser.getId());
        Note newNote = service.createNewNote(comId);
        return DTOMapper.note2NoteRespDTO(newNote);
    }

    @Override
    public NoteRespDTO createNewNote(NoteReqDTO note) {
        return null;
    }

    @GetMapping("/api/note/{id}")
    public NoteRespDTO getNoteById(@PathVariable(value = "id") Long id) {
        return service.getNoteById(id);
    }

    @GetMapping("/api/note")
    public List<NoteRespDTO> getAllNotes(@RequestHeader (name="Authorization") String token) {
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = (String) authentication.getPrincipal();

        User newUser = userService.findUserByUsername(username);

        return service.getAllNotesByUserId(newUser.getId());
    }

    @GetMapping("/api/note/user/{id}")
    public List<NoteRespDTO> getAllNotesByUserId(@PathVariable(value = "id") Long userId) {
        return service.getAllNotesByUserId(userId);
    }

    @PutMapping("/api/note")
    public NoteRespDTO updateNote(@RequestBody NoteReqForUpdateDTO note) {
        return service.updateNote(note);
    }

    @Override
    public List<NoteRespDTO> getAllNotes() {
        return null;
    }

    @DeleteMapping("/api/note/{id}")
    public Long deleteNoteById(@PathVariable(value = "id") Long id) {
        return service.deleteNoteById(id);
    }
}
