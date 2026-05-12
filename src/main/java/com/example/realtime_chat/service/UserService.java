package com.example.realtime_chat.service;

import com.example.realtime_chat.dto.ApiResponse;
import com.example.realtime_chat.dto.UserRequest;
import com.example.realtime_chat.dto.UserResponse;
import com.example.realtime_chat.entity.User;
import com.example.realtime_chat.exception.InvalidPasswordException;
import com.example.realtime_chat.exception.UserNotFoundException;
import com.example.realtime_chat.jwt.JwtUtil;
import com.example.realtime_chat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public void register(UserRequest request) {

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);
    }

    public ApiResponse<String> login(UserRequest request) {

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(UserNotFoundException::new);

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new InvalidPasswordException();
        }

        String token = JwtUtil.createToken(user.getUsername());
        return new ApiResponse<>(true, "로그인 성공", token);
    }

    public ApiResponse<UserResponse> getUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);

        UserResponse response = new UserResponse();

        response.setId(user.getId());
        response.setUsername(user.getUsername());

        return new ApiResponse<>(true, "유저 조회 성공", response);
    }
}
