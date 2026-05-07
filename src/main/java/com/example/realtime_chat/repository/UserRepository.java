package com.example.realtime_chat.repository;

import com.example.realtime_chat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
