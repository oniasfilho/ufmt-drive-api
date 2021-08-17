package io.oniasfilho.ufmtdrive.repository;

import io.oniasfilho.ufmtdrive.entity.Note;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NoteRepository extends CrudRepository<Note, Long> {

    @Query(value = "select * from note where user_id = :userId", nativeQuery = true)
    public List<Note> getNotesByUserId(Long userId);
}
