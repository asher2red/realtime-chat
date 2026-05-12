package com.example.realtime_chat.controller;

import com.example.realtime_chat.dto.ApiResponse;
import com.example.realtime_chat.dto.UserRequest;
import com.example.realtime_chat.dto.UserResponse;
import com.example.realtime_chat.jwt.JwtUtil;
import com.example.realtime_chat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ApiResponse<Void> register(@RequestBody UserRequest request) {

        userService.register(request);

        return new ApiResponse<>(true, "회원 가입 완료", null);
    }

    @PostMapping("/login")
    public ApiResponse<String> login(@RequestBody UserRequest request) {

        return userService.login(request);
    }

    @GetMapping("/{id}")
    public ApiResponse<UserResponse> getUser(@PathVariable Long id) {

        return userService.getUser(id);
    }

    @GetMapping("/me")
    public String me(Authentication authentication) {

        return "현재 사용자: " + authentication.getName();
    }

    @GetMapping("/admin")
    public String admin() {
        return "관리자 페이지";
    }
}
