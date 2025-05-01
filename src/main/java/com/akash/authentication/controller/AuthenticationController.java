package com.akash.authentication.controller;

import com.akash.authentication.model.User;
import com.akash.authentication.model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/akash/signup")
    public ResponseEntity<User> addUser(@RequestBody User body) {
        body.setPassword(encoder.encode(body.getPassword()));
        User user = userService.createUser(body);
        if (Objects.nonNull(user)) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.badRequest().body(null);
    }

//    @PostMapping("/akash/login")
//    public ResponseEntity<User> loginUser(@RequestBody User user) {
//        if (userService.loginUser(user)) {
//            return ResponseEntity.ok(user);
//        }
//        return ResponseEntity.badRequest().body(null);
//    }
}