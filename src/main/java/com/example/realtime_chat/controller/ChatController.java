package com.example.realtime_chat.controller;

import com.example.realtime_chat.dto.ChatMessage;
import com.example.realtime_chat.dto.ChatResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import java.security.Principal;

import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public ChatResponse sendMessage(ChatMessage message, SimpMessageHeaderAccessor accessor) {

        String username = (String) accessor.getSessionAttributes().get("username");

        System.out.println("사용자 이름: " + username);

        return new ChatResponse(username, message.getMessage());
    }
}
