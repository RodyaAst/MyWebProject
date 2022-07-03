package com.mywebapp.medicineproject.controllers;

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

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@NonNull String name) {
        userService.addUser(name);
        return ResponseEntity.ok("user added");
    }
}
