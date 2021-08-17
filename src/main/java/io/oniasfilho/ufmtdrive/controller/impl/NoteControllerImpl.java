package io.oniasfilho.ufmtdrive.controller.impl;

import io.oniasfilho.ufmtdrive.controller.NoteController;
import io.oniasfilho.ufmtdrive.dto.NoteReqDTO;
import io.oniasfilho.ufmtdrive.dto.NoteReqForUpdateDTO;
import io.oniasfilho.ufmtdrive.dto.util.DTOMapper;
import io.oniasfilho.ufmtdrive.dto.NoteRespDTO;
import io.oniasfilho.ufmtdrive.service.NoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteControllerImpl implements NoteController {

    NoteService service;

    public NoteControllerImpl(NoteService service) {
        this.service = service;
    }

    @PostMapping("/api/note")
    public NoteRespDTO createNewNote(@RequestBody NoteReqDTO note) {
        NoteRespDTO response = DTOMapper.note2NoteRespDTO(service.createNewNote(DTOMapper.noteReqDTO2Note(note)));
        return response;
    }

    @GetMapping("/api/note/{id}")
    public NoteRespDTO getNoteById(@PathVariable(value = "id") Long id) {
        return service.getNoteById(id);
    }

    @GetMapping("/api/note")
    public List<NoteRespDTO> getAllNotes() {
        return service.getAllNotes();
    }

    @GetMapping("/api/note/user/{id}")
    public List<NoteRespDTO> getAllNotesByUserId(@PathVariable(value = "id") Long userId) {
        return service.getAllNotesByUserId(userId);
    }

    @PutMapping("/api/note")
    public NoteRespDTO updateNote(@RequestBody NoteReqForUpdateDTO note) {
        return service.updateNote(note);
    }

    @DeleteMapping("/api/note/{id}")
    public Long deleteNoteById(@PathVariable(value = "id") Long id) {
        return service.deleteNoteById(id);
    }
}
