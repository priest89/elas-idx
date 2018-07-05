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
 * The persistent class for the PARENTAL_RATING database table.
 * 
 */
@Entity
@Table(name = "parental_rating")
public class ParentalRating implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "parental_rating_id")
	private long parentalRatingId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", columnDefinition = "DATETIME", insertable = false, updatable = false)
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastmodified", columnDefinition = "DATETIME", insertable = false, updatable = false)
	private Date lastmodified;

	@Column(name = "parental_rating", length = 64, nullable = false)
	private String parentalRating;
	
	@Column(name = "parental_rating_age")
	private Integer ratingAge;

    //bi-directional many-to-one association to Region
    @ManyToOne(cascade = {CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;

	//bi-directional many-to-one association to Channel
//	@OneToMany(mappedBy = "parentalRating", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//	private List<Channel> channels;



	//bi-directional many-to-one association to Video
//	@OneToMany(mappedBy = "parentalRating", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//	private List<Video> videos;

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

	public ParentalRating() {
	}

	public long getParentalRatingId() {
		return this.parentalRatingId;
	}

	public void setParentalRatingId(long parentalRatingId) {
		this.parentalRatingId = parentalRatingId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public Date getLastmodified() {
		return this.lastmodified;
	}

	public String getParentalRating() {
		return this.parentalRating;
	}

	public void setParentalRating(String parentalRating) {
		this.parentalRating = parentalRating;
	}

	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Integer getRatingAge() {
		return ratingAge;
	}

	public void setRatingAge(Integer ratingAge) {
		this.ratingAge = ratingAge;
	}
}