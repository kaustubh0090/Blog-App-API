package com.blog.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.blog.app.payloads.UserDto;
import com.blog.app.services.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/blog/api/")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    @RequestMapping("saveUser")
    ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {

        UserDto user = userService.createUser(userDto);

        return new ResponseEntity<>(user, HttpStatus.CREATED);

    }

    @PutMapping
    @RequestMapping("updateUser/{userId}")
    ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer userId) {

        UserDto updatedUser = userService.updateUser(userDto, userId);

        return ResponseEntity.ok(updatedUser);

    }

    @GetMapping
    @RequestMapping("getUserById/{userId}")
    ResponseEntity<UserDto> getUserById(@PathVariable("userId") Integer userId) {

        UserDto user = userService.getUserById(userId);

        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);

    }

    @GetMapping
    @RequestMapping("allUsers")
    ResponseEntity<List<UserDto>> getAllUsers() {

        List<UserDto> users = userService.getAllUsers();

        return ResponseEntity.ok(users);

    }

    @DeleteMapping
    @RequestMapping("deleteUser/{userId}")
    ResponseEntity<?> deleteUserById(@PathVariable("userId") Integer userId) {

        userService.deleteUserById(userId);

        return new ResponseEntity<>(Map.of("message", "User deleted successfully"), HttpStatus.OK);

    }

}
