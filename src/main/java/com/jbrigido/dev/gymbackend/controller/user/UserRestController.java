package com.jbrigido.dev.gymbackend.controller.user;

import com.jbrigido.dev.gymbackend.entities.user.UserEntity;
import com.jbrigido.dev.gymbackend.services.user.UserService;
import com.jbrigido.dev.gymbackend.services.user.UserServiceImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    private UserService service;

    public UserRestController(UserServiceImplementation service) {
        this.service = service;
    }

    @GetMapping
    public String greeting() {
        return "Hello";
    }

    @PostMapping("/register")
    public ResponseEntity<?> save(@RequestBody UserEntity user) {
        if (!service.isAvailable(user)) {
            return new ResponseEntity<>("Email or username used by another user", HttpStatus.BAD_REQUEST);
        }
        service.register(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody UserEntity request, @PathVariable Long id) {
        Optional<UserEntity> user = service.findById(id);
        if (user.isEmpty()) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        request.setIdUser(id);
        service.update(request);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> patchUpdate(@RequestBody UserEntity request, @PathVariable Long id) {
        Optional<UserEntity> user = service.findById(id);
        if (user.isEmpty()) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        UserEntity recovered = user.get();

        if (request.getName() != null) {
            recovered.setName(request.getName());
        }
        if (request.getLastname() != null) {
            recovered.setLastname(request.getLastname());
        }
        if (request.getEmail() != null) {
            recovered.setEmail(request.getEmail());
        }
        if (request.getBirthday() != null) {
            recovered.setBirthday(request.getBirthday());
        }
        if (request.getRole() != null) {
            recovered.setRole(request.getRole());
        }
        if (request.getUsername() != null) {
            recovered.setUsername(request.getUsername());
        }
        if (request.getPassword() != null) {
            recovered.setPassword(request.getPassword());
        }
        if (request.getStatus() != null) {
            recovered.setStatus(request.getStatus());
        }
        service.update(recovered);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
