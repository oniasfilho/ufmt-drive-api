package io.oniasfilho.ufmtdrive.repository;

import io.oniasfilho.ufmtdrive.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query("select u from user_data u where u.username = :username")
    public User findByUsername(@Param("username") String username);
}
