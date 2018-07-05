package com.pirest.elas.idx.index;

public class IndexRequest {
	public enum IndexType {
		INDEX, DELETE
	}

	public Document document;
	public IndexType indexType;
	public long timeStamp;
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
