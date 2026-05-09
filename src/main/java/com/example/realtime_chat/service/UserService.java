package com.example.realtime_chat.service;

import com.example.realtime_chat.dto.UserRequest;
import com.example.realtime_chat.dto.UserResponse;
import com.example.realtime_chat.entity.User;
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

    public String login(UserRequest request) {

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("유저 없음"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("비밀번호 틀림");
        }

        return JwtUtil.createToken(user.getUsername());
    }

    public UserResponse getUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("유저 없음"));

        UserResponse response = new UserResponse();

        response.setId(user.getId());
        response.setUsername(user.getUsername());

        return response;
    }
}
