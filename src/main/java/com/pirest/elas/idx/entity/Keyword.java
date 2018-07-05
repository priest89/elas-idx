package com.pirest.elas.idx.entity;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



/**
 * The persistent class for the KEYWORD database table.
 * 
 */
@Entity
@Table(name = "keyword") 
public class Keyword implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "keyword_id")
	private long keywordId;

	private String keyword;

    //bi-directional many-to-one association to Language
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "language_id")
    private Language language;

	//bi-directional many-to-many association to Keyword
//	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//	@JoinTable(
//		name="KEYWORD_TO_KEYWORD"
//		, joinColumns={
//			@JoinColumn(name = "keyword_id_2")
//			}
//		, inverseJoinColumns={
//			@JoinColumn(name = "keyword_id_1")
//			}
//		)
//	private List<Keyword> keywords1;

	//bi-directional many-to-many association to Keyword
//	@ManyToMany(mappedBy = "keywords1", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//	private List<Keyword> keywords2;

	//bi-directional many-to-many association to Video
//	@ManyToMany(mappedBy = "keywords", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//	private List<Video> videos;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", columnDefinition = "DATETIME", insertable = false, updatable = false)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastmodified", columnDefinition = "DATETIME", insertable = false, updatable = false)
    private Date lastmodified;

    @PrePersist
    protected void onCreate() {
        Date date = new Date();
        createDate = date;
        lastmodified = date;
    }

    @PreUpdate
    protected void onUpdate() {
        lastmodified = new Date();
    }

	public Keyword() {
	}

	public long getKeywordId() {
		return this.keywordId;
	}

	public void setKeywordId(long keywordId) {
		this.keywordId = keywordId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Date getLastmodified() {
		return this.lastmodified;
	}

	public void setLastmodified(Date lastmodified) {
		this.lastmodified = lastmodified;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}