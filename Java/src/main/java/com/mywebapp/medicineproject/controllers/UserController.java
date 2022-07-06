package com.mywebapp.medicineproject.controllers;

import com.mywebapp.medicineproject.inputs.UserInput;
import com.mywebapp.medicineproject.services.UserService;
import lombok.extern.slf4j.Slf4j;
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

    @GetMapping("/byId")
    public ResponseEntity<?> showUser(@NonNull @RequestParam Long id) {
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
        var userList = userService.findByFilters();
        log.info(userList.toString());
        return ResponseEntity.ok(userList);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@NonNull @RequestBody UserInput user) {
        userService.addUser(user);
        return ResponseEntity.ok().build();
    }


}
