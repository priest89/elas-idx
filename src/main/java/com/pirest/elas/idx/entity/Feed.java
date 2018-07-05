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
 * The persistent class for the FEED database table.
 * 
 */
@Entity
@Table(name = "feed") 
public class Feed implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "feed_id")
	private long feedId;

	@Column(name = "mrss_url", length = 2048)
	private String mrssUrl;

	@ManyToOne(cascade = {CascadeType.REFRESH}, optional = false)
	@JoinColumn(name = "partner_id", nullable = false)
	private ContentPartner contentPartner;

	@ManyToOne(cascade = {CascadeType.REFRESH}, optional = false)
	@JoinColumn(name = "feed_origin_id", nullable = false)
	private FeedOrigin feedOrigin;

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

	public Feed() {
	}

	public long getFeedId() {
		return this.feedId;
	}

	public void setFeedId(long feedId) {
		this.feedId = feedId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public Date getLastmodified() {
		return this.lastmodified;
	}

	public String getMrssUrl() {
		return this.mrssUrl;
	}

	public void setMrssUrl(String mrssUrl) {
		this.mrssUrl = mrssUrl;
	}

	public ContentPartner getContentPartner() {
		return this.contentPartner;
	}

	public void setContentPartner(ContentPartner contentPartner) {
		this.contentPartner = contentPartner;
	}

	public FeedOrigin getFeedOrigin() {
		return this.feedOrigin;
	}

	public void setFeedOrigin(FeedOrigin feedOrigin) {
		this.feedOrigin = feedOrigin;
	}

}