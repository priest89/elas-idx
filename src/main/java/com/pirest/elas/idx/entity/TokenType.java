package com.pirest.elas.idx.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "token_type")
public class TokenType implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "token_type_id")
	private Long tokenTypeId;
	
	@Column(name = "token_type_name", length = 45, nullable = false)
	private String tokenTypeName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", columnDefinition = "DATETIME", insertable = false, updatable = false)
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastmodified", columnDefinition = "DATETIME", insertable = false, updatable = false)
	private Date lastmodified;

	public Long getTokenTypeId() {
		return tokenTypeId;
	}

	public void setTokenTypeId(Long tokenTypeId) {
		this.tokenTypeId = tokenTypeId;
	}

	public String getTokenTypeName() {
		return tokenTypeName;
	}

	public void setTokenTypeName(String tokenTypeName) {
		this.tokenTypeName = tokenTypeName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastmodified() {
		return lastmodified;
	}

	public void setLastmodified(Date lastmodified) {
		this.lastmodified = lastmodified;
	}
}
