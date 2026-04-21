package com.jbrigido.dev.gymbackend.services.user;

import com.jbrigido.dev.gymbackend.entities.user.UserEntity;

public  interface UserService {

    void signIn(UserEntity user);
    void register(UserEntity user);
    boolean isAvailable(UserEntity user);
}
