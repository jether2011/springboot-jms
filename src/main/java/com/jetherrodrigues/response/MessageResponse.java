package com.jetherrodrigues.response;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public final class MessageResponse implements Serializable {

	private static final long serialVersionUID = 1L;
    private int code;
    private String description;
    private String message;

    public MessageResponse() {}

    public MessageResponse(HttpStatus status, String message) {
        this.code = status.value();
        this.description = status.getReasonPhrase();
        this.message = message;
    }

    public int getCode() {
        return this.code;   
    }

    public String getDescription() {
        return this.description;   
    }

    public String getMessage() {
        return this.message;   
    }
}