package com.jbrigido.dev.gymbackend.services.user;

import com.jbrigido.dev.gymbackend.entities.user.UserEntity;

interface UserService {

    void signIn(UserEntity user);
    void save(UserEntity user);
}
