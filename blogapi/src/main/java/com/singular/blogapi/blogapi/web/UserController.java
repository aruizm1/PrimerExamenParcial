package com.singular.blogapi.blogapi.web;

import com.singular.blogapi.blogapi.domain.User;
import com.singular.blogapi.blogapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {this.service = service; }


    @GetMapping("/all-user")
    public List<User> allUser() {
        return service.findAllUser();
    }

    @PostMapping("/register-user")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        service.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update-user")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        service.updateUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
