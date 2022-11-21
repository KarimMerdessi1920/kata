package com.margo.kata.dto;

public class TransactionResponse {
    private String action;
    private String message;

    public TransactionResponse() {
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TransactionResponse(String action, String message) {
        this.action = action;
        this.message = message;
    }
}
