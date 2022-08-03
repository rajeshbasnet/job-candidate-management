package com.example.jobcandidatemanagement.controller;

import com.example.jobcandidatemanagement.dto.UserDto;
import com.example.jobcandidatemanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserFromUserId(@PathVariable("id") int id) {
        return new ResponseEntity<UserDto>(userService.getUserFromUserId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody UserDto userDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body("User has been created successfully.");
    }
}
