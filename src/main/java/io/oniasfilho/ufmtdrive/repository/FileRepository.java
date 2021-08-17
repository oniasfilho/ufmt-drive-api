package io.oniasfilho.ufmtdrive.repository;

import io.oniasfilho.ufmtdrive.entity.File;
import org.springframework.data.repository.CrudRepository;

public interface FileRepository extends CrudRepository<File, Long> {
}
