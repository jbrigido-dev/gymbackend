package com.jbrigido.dev.gymbackend.services.user;

import com.jbrigido.dev.gymbackend.entities.user.UserEntity;
import com.jbrigido.dev.gymbackend.repositories.user.UserRepository;

public class UserServiceImplementation implements UserService {

    private UserRepository repository;

    public UserServiceImplementation(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void signIn(UserEntity user) {
    }
}
