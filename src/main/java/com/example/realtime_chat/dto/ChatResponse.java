package com.example.realtime_chat.dto;

public class ChatResponse {

    private Long roomId;
    private String sender;
    private String message;
    private String type;

    public ChatResponse() {

    }

    public ChatResponse(Long roomId, String sender, String message, String type) {
        this.roomId = roomId;
        this.sender = sender;
        this.message = message;
        this.type = type;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
