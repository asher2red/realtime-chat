package com.example.realtime_chat.event;

import com.example.realtime_chat.dto.ChatResponse;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;

import org.springframework.stereotype.Component;

import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class WebSocketEventListener {

    private final SimpMessagingTemplate messagingTemplate;

    public WebSocketEventListener(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @EventListener
    public void handdleConnet(SessionConnectEvent event) {

        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());

        String username = (String) accessor.getSessionAttributes().get("username");

        String roomId = (String) accessor.getSessionAttributes().get("roomId");

        if (username != null && roomId != null) {

            ChatResponse response = new ChatResponse(
                    Long.parseLong(roomId),
                    username,
                    username + " 님이 입장했습니다.",
                    "JOIN"
            );

            messagingTemplate.convertAndSend(
                    "/topic/room/" + roomId,
                    response
            );
        }
    }

    @EventListener
    public void handleDisconnect(SessionDisconnectEvent event) {

        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());

        String username = (String) accessor.getSessionAttributes().get("username");

        String roomId = (String) accessor.getSessionAttributes().get("roomId");

        if (username != null && roomId != null) {
            ChatResponse response = new ChatResponse(
                    Long.parseLong(roomId),
                    username,
                    username + " 님이 퇴장했습니다.",
                    "LEAVE"
            );

            messagingTemplate.convertAndSend(
                    "/topic/room/" + roomId,
                    response
            );
        }
    }
}
