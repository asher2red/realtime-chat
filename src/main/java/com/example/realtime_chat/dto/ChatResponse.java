package com.example.realtime_chat.dto;

public class ChatResponse {

    private String sender;
    private String message;

    public ChatResponse() {

    }

    public ChatResponse(String sender, String message) {
        this.sender = sender;
        this.message = message;
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
