package com.jbrigido.dev.gymbackend.repositories.user;

import com.jbrigido.dev.gymbackend.entities.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByEmail(String emai);

    boolean existsByUsername(String username);

}
