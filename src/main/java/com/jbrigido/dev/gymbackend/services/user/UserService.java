package com.jbrigido.dev.gymbackend.services.user;

import com.jbrigido.dev.gymbackend.entities.user.UserEntity;

import java.util.Optional;

public  interface UserService {

    void signIn(UserEntity user);
    void register(UserEntity user);
    boolean isAvailable(UserEntity user);
    void update(UserEntity user);
    Optional<UserEntity> findById(Long id);
}
