package com.jbrigido.dev.gymbackend.controller.user;

import com.jbrigido.dev.gymbackend.entities.user.UserEntity;
import com.jbrigido.dev.gymbackend.services.user.UserService;
import com.jbrigido.dev.gymbackend.services.user.UserServiceImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        if (service.isAvailable(user)) {
            service.register(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else
            return new ResponseEntity<>("Email or username used by another user", HttpStatus.BAD_REQUEST);

    }
}
