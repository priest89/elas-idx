package com.pirest.elas.idx.index;

import java.util.Collection;

public class Document {
	public enum DocType {
		CHANNEL, VIDEO
	}

	private DocType docType;
	private Collection<String> ids;

	public Document(DocType docType, Collection<String> ids) {
		super();
		this.docType = docType;
		this.ids = ids;
	}

	public DocType getDocType() {
		return docType;
	}

	public void setDocType(DocType docType) {
		this.docType = docType;
	}

	public Collection<String> getIds() {
		return ids;
	}

	public void setIds(Collection<String> ids) {
		this.ids = ids;
	}

}
