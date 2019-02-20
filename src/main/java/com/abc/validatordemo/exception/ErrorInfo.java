package com.abc.validatordemo.exception;

public class ErrorInfo {
    private String message;
    private int statusCode;

    public ErrorInfo(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }
}
