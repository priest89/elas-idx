package com.pirest.elas.idx.exception;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

@ControllerAdvice
public class APIExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private ObjectMapper objectMapper;

	@ExceptionHandler({ Exception.class })
	protected ResponseEntity<Object> handleExceptions(final Exception e, final WebRequest request) {

		Map<String, Object> response;

		if (e instanceof APIException) {
			APIException apiException = (APIException) e;
			response = apiException.toResponse();
		} else if (e instanceof HttpStatusCodeException) {
			response = new HashMap<>();
			try {
				Map body = objectMapper.readValue(((HttpStatusCodeException) e).getResponseBodyAsString(), Map.class);
				if (body.get("message") != null) {
					response.put("message", body.get("message"));
				}
			} catch (Exception ex) {
				response.put("message", ((HttpStatusCodeException) e).getResponseBodyAsString());
			}
			response.put("status", ((HttpStatusCodeException) e).getStatusCode().value());
		} else if (e instanceof Exception && StringUtils.isNoneBlank(e.getMessage())) {
			response = new HashMap<>();
			response.put("message", e.getMessage());
		} else {
			response = new HashMap<>();
			response.put("message", "Unknown error");
		}

		Object status = response.get("status");
		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		if (status != null) {
			if (status instanceof Integer) {
				httpStatus = HttpStatus.valueOf((Integer) status);
			} else if (status instanceof HttpStatus) {
				httpStatus = (HttpStatus) status;
			}
		}
		response.put("status", httpStatus.value());

		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return handleExceptionInternal(e, response, headers, httpStatus, request);
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		log(status, body, ex);
		return super.handleExceptionInternal(ex, body, headers, status, request);
	}

	@Bean
	public ErrorAttributes errorAttributes() {
		return new DefaultErrorAttributes() {
			@Override
			public Map<String, Object> getErrorAttributes(WebRequest requestAttributes, boolean includeStackTrace) {
				// clean all spring default error response
				Map<String, Object> attributes = super.getErrorAttributes(requestAttributes, false);
				attributes.remove("timestamp");
				attributes.remove("path");
				attributes.remove("exception");
				attributes.put("message", attributes.get("error"));
				attributes.remove("error");
				return attributes;
			}
		};
	}

	private void log(final HttpStatus httpStatus, final Object body, final Exception ex) {
		if (HttpStatus.INTERNAL_SERVER_ERROR.equals(httpStatus)) {
			logger.error(body, ex);
		} else {
			logger.warn(body, ex);
		}
	}
}