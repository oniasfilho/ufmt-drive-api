package io.oniasfilho.ufmtdrive.controller;

import io.oniasfilho.ufmtdrive.dto.NoteReqDTO;
import io.oniasfilho.ufmtdrive.dto.NoteReqForUpdateDTO;
import io.oniasfilho.ufmtdrive.dto.NoteRespDTO;

import java.util.List;

public interface NoteController {

    public NoteRespDTO createNewNote(NoteReqDTO note);
    public NoteRespDTO getNoteById(Long id);
    public List<NoteRespDTO> getAllNotesByUserId(Long userId);
    public NoteRespDTO updateNote(NoteReqForUpdateDTO note);
    public List<NoteRespDTO> getAllNotes();
    public Long deleteNoteById(Long id);


}
