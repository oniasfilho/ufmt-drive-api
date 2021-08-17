package io.oniasfilho.ufmtdrive.repository;

import io.oniasfilho.ufmtdrive.entity.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {
}
