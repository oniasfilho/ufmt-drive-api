package io.oniasfilho.ufmtdrive.repository;

import io.oniasfilho.ufmtdrive.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
