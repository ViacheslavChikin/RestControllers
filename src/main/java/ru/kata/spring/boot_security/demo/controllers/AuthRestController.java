package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.AuthService;

import java.util.List;


@RestController
@RequestMapping("/apiAuth")
public class AuthRestController {


    private final AuthService service;

    public AuthRestController(AuthService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> showAllUsers() {
        List<User> userList = service.getAll();
        return ResponseEntity.ok(userList);
    }

    @PostMapping("/users")
    public ResponseEntity<User> postNewUser(@RequestBody User user) {
        service.createUser(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/users")
    public ResponseEntity<HttpStatus> updateUser(@RequestBody User user) {
        service.update(user, user.getId());
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Integer id) {
        service.deleteUser(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
