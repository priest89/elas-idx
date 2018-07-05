package com.pirest.elas.idx.index;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IndexRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum IndexType {
		INDEX, DELETE
	}

	public Document document;

	@JsonProperty(value = "index_type")
	public IndexType indexType;

	@JsonProperty(value = "time_stamp")
	public long timeStamp;

	@JsonProperty(value = "tried_count")
	public int triedCount;

	public IndexRequest(Document document, IndexType indexType) {
		super();
		this.document = document;
		this.indexType = indexType;
	}

	public int getTriedCount() {
		return triedCount;
	}

	public void setTriedCount(int triedCount) {
		this.triedCount = triedCount;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public IndexType getIndexType() {
		return indexType;
	}

	public void setIndexType(IndexType indexType) {
		this.indexType = indexType;
	}
}
