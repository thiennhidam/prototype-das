package com.das.authservice.controller;

import com.das.authservice.model.UserData;
import com.das.authservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestParam("email") String email, @RequestParam("password") String password){
        System.out.println("Login!!" + email + " - " + password);
        UserData userData = userService.getUserByEmailAndPassword(email, password);
        if(userData != null){
            System.out.println("success");
            return ResponseEntity.status(HttpStatus.OK).body(userData);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
    @GetMapping("/get")
    public ResponseEntity get(){
        UserData userData = new UserData();
        userData.setId(2);
        userData.setEmail("another@mail.com");
        userData.setLastname("Someone");
        return ResponseEntity.status(HttpStatus.OK).body(userData);
    }

}
