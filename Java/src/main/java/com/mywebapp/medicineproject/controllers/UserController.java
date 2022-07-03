package com.mywebapp.medicineproject.controllers;

import com.mywebapp.medicineproject.inputs.UserInput;
import com.mywebapp.medicineproject.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    private final UserService userService;

    public UserController(@NonNull UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/byId")
    public ResponseEntity<?> showUser(@NonNull @RequestParam Long id) {
        var user = userService.findUser(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users")
    public ResponseEntity<?> showAllUsers() {
        var userList = userService.findAllUsers();
        return ResponseEntity.ok(userList);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@NonNull @RequestBody UserInput user) {
        userService.addUser(user);
        return ResponseEntity.ok().build();
    }
}
