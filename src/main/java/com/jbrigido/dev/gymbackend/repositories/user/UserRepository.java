package com.jbrigido.dev.gymbackend.repositories.user;

import com.jbrigido.dev.gymbackend.entities.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

interface UserRepository extends JpaRepository<UserEntity, Long> {
}
