package com.jbrigido.dev.gymbackend.repositories.user;

import com.jbrigido.dev.gymbackend.entities.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmailOrUsername(String email, String username);
}
