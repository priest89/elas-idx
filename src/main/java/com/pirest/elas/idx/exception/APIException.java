package com.pirest.elas.idx.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class APIException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
    private HttpStatus status;

    public APIException(String message) {
        this.message = message;
    }

    public APIException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    @JsonCreator
    public APIException(@JsonProperty("message") String message, @JsonProperty("status") int code) {
        this(message, HttpStatus.valueOf(code));
    }

    public APIException(Throwable cause, String message) {
        super(cause);
        this.message = message;
    }

    public APIException(Throwable cause, String message, HttpStatus status) {
        super(cause);
        this.message = message;
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Map<String, Object> toResponse() {
        final Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        if (status != null) {
            map.put("status", status.value());
        }
        return map;
    }
}