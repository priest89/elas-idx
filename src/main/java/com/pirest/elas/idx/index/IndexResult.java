package com.pirest.elas.idx.index;

public class IndexResult {
	public enum Status {
		FAIL, SUCCESS
	}

	private Status status;
	private String message;
	private Exception exception;
	private IndexRequest indexRequest;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	public IndexRequest getIndexRequest() {
		return indexRequest;
	}

	public void setIndexRequest(IndexRequest indexRequest) {
		this.indexRequest = indexRequest;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
