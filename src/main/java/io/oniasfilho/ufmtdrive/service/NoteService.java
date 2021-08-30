package io.oniasfilho.ufmtdrive.service;

import io.oniasfilho.ufmtdrive.dto.NoteReqDTO;
import io.oniasfilho.ufmtdrive.dto.NoteReqForUpdateDTO;
import io.oniasfilho.ufmtdrive.dto.NoteRespDTO;
import io.oniasfilho.ufmtdrive.entity.Note;

import java.util.List;

public interface NoteService {
    public Note createNewNote(NoteReqDTO note);
    public NoteRespDTO getNoteById(Long id);
    public List<NoteRespDTO> getAllNotesByUserId(Long userId);
    public NoteRespDTO updateNote(NoteReqForUpdateDTO note);
    public Long deleteNoteById(Long id);
    public List<NoteRespDTO> getAllNotes();
}
