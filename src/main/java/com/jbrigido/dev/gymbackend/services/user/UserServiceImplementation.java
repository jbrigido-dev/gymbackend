package com.jbrigido.dev.gymbackend.services.user;

import com.jbrigido.dev.gymbackend.entities.user.UserEntity;
import com.jbrigido.dev.gymbackend.repositories.user.UserRepository;

import java.util.Optional;

public class UserServiceImplementation implements UserService {

    private UserRepository repository;

    public UserServiceImplementation(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void signIn(UserEntity user) {
    }

    @Override
    public void save(UserEntity user) {
        Optional<UserEntity> found = repository.findByEmailOrUsername(user.getEmail(), user.getUsername());
        if (found.isPresent()) {
            throw new RuntimeException("Email or Username used by another user");
        }

        repository.save(user);

    }
}
