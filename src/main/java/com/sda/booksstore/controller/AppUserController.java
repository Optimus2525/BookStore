package com.sda.booksstore.controller;

import com.sda.booksstore.model.AppUser;
import com.sda.booksstore.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class AppUserController {

    private final UserServiceImpl userServiceImpl;

    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getAppUsers() {
        return ResponseEntity.ok().body(userServiceImpl.getUsers());
    }

}
