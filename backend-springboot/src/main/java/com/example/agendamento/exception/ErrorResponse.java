package com.example.agendamento.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    private LocalDateTime timeStamp;
    private String message;
    private String details;

    public ErrorResponse(String message, String details) {
        this.timeStamp = LocalDateTime.now();
        this.message = message;
        this.details = details;
    }
}
