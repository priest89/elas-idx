package com.pirest.elas.idx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "content_format")
public class ContentFormat {
    @Id
    @GeneratedValue
    @Column(name = "content_format_id", insertable = false, updatable = false, nullable = false, unique = true)
    private int contentFormatId;

    @Column(name = "content_format")
    private String contentFormat;

	public int getContentFormatId() {
		return contentFormatId;
	}

	public void setContentFormatId(int contentFormatId) {
		this.contentFormatId = contentFormatId;
	}

	public String getContentFormat() {
		return contentFormat;
	}

	public void setContentFormat(String contentFormat) {
		this.contentFormat = contentFormat;
	}
}
