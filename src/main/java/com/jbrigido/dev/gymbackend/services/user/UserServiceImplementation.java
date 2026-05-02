package com.jbrigido.dev.gymbackend.services.user;

import com.jbrigido.dev.gymbackend.entities.user.UserEntity;
import com.jbrigido.dev.gymbackend.repositories.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    private UserRepository repository;

    public UserServiceImplementation(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UserEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public void signIn(UserEntity user) {
    }

    @Override
    public void register(UserEntity user) {
        repository.save(user);
    }

    @Override
    public boolean isAvailable(UserEntity user) {
        return !repository.existsByEmail(user.getEmail()) && !repository.existsByUsername(user.getUsername());
    }

    @Override
    public void update(UserEntity user) {
        repository.save(user);
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        return repository.findById(id);
    }

}
