package com.example.realtime_chat.repository;

import com.example.realtime_chat.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Long> {

    List<Chat> findByRoomIdOrderByCreatedAtAsc(Long roomId);
}
