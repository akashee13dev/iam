package com.akash.authentication.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repo.findUserByName(username);
        if (user.isPresent()) {
            User useObj = user.get();
            return org.springframework.security.core.userdetails.User.builder()
                    .username(useObj.getName())
                    .password(useObj.getPassword())
                    .build();
        } else {
            throw new UsernameNotFoundException(username);
        }
    }

    public User createUser(User newUser) {
        if (isValidUser(newUser)) {
            Optional<User> user = repo.findUserByName(newUser.getName());
            if (user.isPresent()) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exists");
            }
            return repo.save(newUser);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid user input");
        }
    }

    private boolean isValidUser(User body) {
        return Objects.nonNull(body) && Objects.nonNull(body.getName()) && Objects.nonNull(body.getEmail()) && Objects.nonNull(body.getPassword());
    }
}