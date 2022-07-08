package com.mywebapp.medicineproject.controllers;

import com.mywebapp.medicineproject.inputs.UserInput;
import com.mywebapp.medicineproject.services.UserService;
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
        var user = userService.findUser(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users")
    public ResponseEntity<?> showAllUsers() {
        var userList = userService.findAllUsers();
        log.info(userList.toString());
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/usersByFilters")
    public ResponseEntity<?> showUsersByFilters(@RequestParam(required = false) String firstName,
                                                @RequestParam(required = false) String lastName,
                                                @RequestParam(required = false) LocalDate birthday,
                                                @RequestParam(required = false) String currentFrom) {
        var userList = userService.findByFilters(firstName, lastName, birthday, currentFrom);
        log.info(userList.toString());
        return ResponseEntity.ok(userList);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@NonNull @RequestBody UserInput userInput) {
        try {
            var user = userService.addUser(userInput);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<?> updateUser(@NonNull @PathVariable Long id) {
        var user = userService.findUser(id);
        userService.updateUser(user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> deleteUser(@NonNull @PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

}
