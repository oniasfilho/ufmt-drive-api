package io.oniasfilho.ufmtdrive.repository;

import io.oniasfilho.ufmtdrive.entity.Credentials;
import org.springframework.data.repository.CrudRepository;

public interface CredentialsRepository extends CrudRepository<Credentials,Long> {
}
