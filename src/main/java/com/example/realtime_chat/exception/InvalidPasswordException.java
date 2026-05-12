package com.example.realtime_chat.exception;

public class InvalidPasswordException extends RuntimeException {

    public InvalidPasswordException() {
        super("비밀번호 틀림");
    }
}