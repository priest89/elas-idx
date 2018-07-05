package com.pirest.elas.idx.index;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Document implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum DocType {
		CHANNEL, VIDEO
	}

	@JsonProperty(value = "doc_type")
	private DocType docType;

	private List<Object> ids;

	public DocType getDocType() {
		return docType;
	}

	public void setDocType(DocType docType) {
		this.docType = docType;
	}

	public List<Object> getIds() {
		return ids;
	}

	public void setIds(List<Object> ids) {
		this.ids = ids;
	}

	public Document(DocType docType, List<Object> ids) {
		super();
		this.docType = docType;
		this.ids = ids;
	}
}
