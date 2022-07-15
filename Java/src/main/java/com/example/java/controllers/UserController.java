package com.example.java.controllers;

import com.example.java.inputs.UserInput;
import com.example.java.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class UserController {

    private final UserService userService;

    public UserController(@NonNull UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}/user")
    public ResponseEntity<?> showUser(@NonNull @PathVariable Long id) {
        try {
            var user = userService.findUser(id);
            log.info(user.toString());
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/users")
    public ResponseEntity<?> showAllUsers() {
        try {
            var userList = userService.findAllUsers();
            log.info(userList.toString());
            return ResponseEntity.ok(userList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/usersByFilters")
    public ResponseEntity<?> showUsersByFilters(@RequestParam(required = false) String firstName,
                                                @RequestParam(required = false) String lastName,
                                                @RequestParam(required = false) LocalDate birthday,
                                                @RequestParam(required = false) String currentFrom) {
        try {
            var userList = userService.findByFilters(firstName, lastName, birthday, currentFrom);
            log.info(userList.toString());
            return ResponseEntity.ok(userList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/user")
    public ResponseEntity<?> addUser(@NonNull @RequestBody UserInput userInput) {
        try {
            var user = userService.addUser(userInput);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/{id}/user")
    public ResponseEntity<?> updateUser(@NonNull @PathVariable Long id,
                                        @RequestBody UserInput userInput) {
        try {
            userService.updateUser(id, userInput);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}/user")
    public ResponseEntity<?> deleteUser(@NonNull @PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
