package com.pirest.elas.idx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "content_type")
public class ContentType {
    @Id
    @GeneratedValue
    @Column(name = "content_type_id", insertable = false, updatable = false, nullable = false, unique = true)
    private int contentTypeId;

    @Column(name = "content_type")
    private String contentType;

	public int getContentTypeId() {
		return contentTypeId;
	}

	public void setContentTypeId(int contentTypeId) {
		this.contentTypeId = contentTypeId;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
}
