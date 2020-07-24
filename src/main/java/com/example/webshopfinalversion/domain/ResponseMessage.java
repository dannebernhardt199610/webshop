package com.example.webshopfinalversion.domain;

public class ResponseMessage {

    private String message;
    private boolean status;

    public ResponseMessage() {
    }

    public ResponseMessage(String message, boolean status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

