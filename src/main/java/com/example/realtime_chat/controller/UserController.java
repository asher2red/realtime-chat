package com.example.realtime_chat.controller;

import com.example.realtime_chat.dto.UserRequest;
import com.example.realtime_chat.dto.UserResponse;
import com.example.realtime_chat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody UserRequest request) {

        userService.register(request);

        return "회원 가입 완료";
    }

    @PostMapping("/login")
    public String login(@RequestBody UserRequest request) {

        return userService.login(request);
    }

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Long id) {

        return userService.getUser(id);
    }
}
