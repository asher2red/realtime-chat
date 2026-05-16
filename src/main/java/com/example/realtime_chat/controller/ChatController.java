package com.example.realtime_chat.controller;

import com.example.realtime_chat.dto.ChatMessage;
import com.example.realtime_chat.dto.ChatResponse;
import com.example.realtime_chat.entity.Chat;
import com.example.realtime_chat.repository.ChatRepository;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;
    private final ChatRepository chatRepository;

    public ChatController(SimpMessagingTemplate messagingTemplate, ChatRepository chatRepository) {
        this.messagingTemplate = messagingTemplate;
        this.chatRepository = chatRepository;
    }

    @MessageMapping("/chat/{roomId}")
    public void sendMessage(@DestinationVariable Long roomId, ChatMessage message, SimpMessageHeaderAccessor accessor) {

        String username = (String) accessor.getSessionAttributes().get("username");

        ChatResponse response = new ChatResponse(roomId, username, message.getMessage(), "CHAT");

        messagingTemplate.convertAndSend("/topic/room/" + roomId, response);

        Chat chat = new Chat();

        chat.setRoomId(roomId);
        chat.setSender(username);
        chat.setMessage(message.getMessage());
        chat.setCreatedAt(LocalDateTime.now());

        chatRepository.save(chat);
    }

    @GetMapping("/chat/room/{roomId}")
    @ResponseBody
    public List<Chat> getMessages(@PathVariable Long roomId) {

        return chatRepository.findByRoomIdOrderByCreatedAtAsc(roomId);
    }
}
