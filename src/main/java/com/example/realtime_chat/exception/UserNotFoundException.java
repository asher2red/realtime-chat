package com.example.realtime_chat.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("유저 없음");
    }
}
