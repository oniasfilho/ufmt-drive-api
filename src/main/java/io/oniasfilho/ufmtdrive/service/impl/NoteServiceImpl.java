package io.oniasfilho.ufmtdrive.service.impl;

import io.oniasfilho.ufmtdrive.dto.NoteReqDTO;
import io.oniasfilho.ufmtdrive.dto.NoteReqForUpdateDTO;
import io.oniasfilho.ufmtdrive.dto.NoteRespDTO;
import io.oniasfilho.ufmtdrive.dto.util.DTOMapper;
import io.oniasfilho.ufmtdrive.entity.Note;
import io.oniasfilho.ufmtdrive.entity.User;
import io.oniasfilho.ufmtdrive.repository.NoteRepository;
import io.oniasfilho.ufmtdrive.repository.UserRepository;
import io.oniasfilho.ufmtdrive.service.NoteService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    NoteRepository repository;
    UserRepository userRepository;

    public NoteServiceImpl(NoteRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public Note createNewNote(Note note) {
        User user = userRepository.findById(note.getUser().getId()).get();
        Note newNote = note;
        newNote.setUser(user);
        repository.save(newNote);
        return newNote;
    }

    @Override
    public NoteRespDTO getNoteById(Long id) {
        return DTOMapper.note2NoteRespDTO(repository.findById(id).get());
    }

    @Override
    public List<NoteRespDTO> getAllNotesByUserId(Long userId) {
        List<Note> notes = repository.getNotesByUserId(userId);
        List<NoteRespDTO> notesDTO = new ArrayList<>();
        notes.forEach(note -> {
            notesDTO.add(DTOMapper.note2NoteRespDTO(note));
        });
        return notesDTO;
    }

    @Override
    public List<NoteRespDTO> getAllNotes() {
        List<Note> notes = new ArrayList<>();
        Iterator<Note> iterator = repository.findAll().iterator();

        iterator.forEachRemaining(each ->{
            notes.add(each);
        });

        List<NoteRespDTO> notesDTO = new ArrayList<>();
        notes.forEach(note -> {
            notesDTO.add(DTOMapper.note2NoteRespDTO(note));
        });
        return notesDTO;
    }

    @Override
    public NoteRespDTO updateNote(NoteReqForUpdateDTO note) {
        Note n1 = repository.findById(note.getNote_id()).get();
        n1.setNoteTitle(note.getNote_title());
        n1.setNoteDescription(note.getNote_description());
        repository.save(n1);
        return DTOMapper.note2NoteRespDTO(n1);
    }

    @Override
    public Long deleteNoteById(Long id) {
        repository.deleteById(id);
        return id;
    }
}
