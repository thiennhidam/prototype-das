package com.das.userservice.controller;

import com.das.userservice.model.UserData;
import com.das.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getUserById(@PathVariable Integer id){
        UserData userData = userService.getUserById(id);
        if(userData != null){
            return ResponseEntity.status(HttpStatus.OK).body(userData);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
