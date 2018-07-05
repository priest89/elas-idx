package com.pirest.elas.idx.entity;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



/**
 * The persistent class for the FEED_QUALITY database table.
 * 
 */
@Entity
@Table(name = "feed_quality")
public class FeedQuality implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "feed_quality_id")
	private long feedQualityId;

    @Column(length = 45)
	private String description;

	@Column(name = "quality_rating")
	private int qualityRating;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", columnDefinition = "DATETIME", insertable = false, updatable = false)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastmodified", columnDefinition = "DATETIME", insertable = false, updatable = false)
    private Date lastmodified;

	//bi-directional many-to-one association to FeedOrigin
//	@OneToMany(mappedBy = "feedQuality", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//	private List<FeedOrigin> feedOrigins;

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

	public FeedQuality() {
	}

	public long getFeedQualityId() {
		return this.feedQualityId;
	}

	public void setFeedQualityId(long feedQualityId) {
		this.feedQualityId = feedQualityId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getLastmodified() {
		return this.lastmodified;
	}

	public int getQualityRating() {
		return this.qualityRating;
	}

	public void setQualityRating(int qualityRating) {
		this.qualityRating = qualityRating;
	}
}