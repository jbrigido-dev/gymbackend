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
}
