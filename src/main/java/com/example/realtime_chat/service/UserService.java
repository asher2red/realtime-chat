package com.example.realtime_chat.service;

import com.example.realtime_chat.dto.UserRequest;
import com.example.realtime_chat.entity.User;
import com.example.realtime_chat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void register(UserRequest request) {

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());

        userRepository.save(user);
    }
}
