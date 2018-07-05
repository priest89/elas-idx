package com.pirest.elas.idx.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InternalAPIException extends APIException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("error_code")
    private Integer errorCode;

    public InternalAPIException(String message, Integer errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public InternalAPIException(String message, HttpStatus status, Integer errorCode) {
        super(message, status);
        this.errorCode = errorCode;
    }

    @JsonCreator
    public InternalAPIException(@JsonProperty("message") String message, @JsonProperty("status") int code, @JsonProperty("error_code") Integer errorCode) {
        super(message, code);
        this.errorCode = errorCode;
    }

    public InternalAPIException(Throwable cause, String message, Integer errorCode) {
        super(cause, message);
        this.errorCode = errorCode;
    }

    public InternalAPIException(Throwable cause, String message, HttpStatus status, Integer errorCode) {
        super(cause, message, status);
        this.errorCode = errorCode;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public Map<String, Object> toResponse() {
        Map map = super.toResponse();
        map.put("error_code", errorCode);
        return map;
    }

}