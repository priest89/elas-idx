package com.pirest.elas.idx.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the BLACKLIST database table.
 * 
 */
@Entity
@Table(name = "blacklist") 
public class Blacklist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "blacklist_id")
	private long blacklistId;

	@Column(name = "period_end")
	private Date periodEnd;

	@Column(name = "period_start")
	private Date periodStart;

	//bi-directional many-to-one association to Account
	@ManyToOne(cascade = {CascadeType.REFRESH}, optional = false)
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;

	//bi-directional many-to-one association to ContentPartner
	@ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
	@JoinColumn(name = "partner_id")
	private ContentPartner contentPartner;

	//bi-directional many-to-one association to Region
	@ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
	@JoinColumn(name = "region_id")
	private Region region;

	//bi-directional many-to-one association to Video
	@ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
	@JoinColumn(name = "video_id")
	private Video video;

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

	public Blacklist() {
	}

	public long getBlacklistId() {
		return this.blacklistId;
	}

	public void setBlacklistId(long blacklistId) {
		this.blacklistId = blacklistId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public Date getLastmodified() {
		return this.lastmodified;
	}

	public Date getPeriodEnd() {
		return this.periodEnd;
	}

	public void setPeriodEnd(Date periodEnd) {
		this.periodEnd = periodEnd;
	}

	public Date getPeriodStart() {
		return this.periodStart;
	}

	public void setPeriodStart(Date periodStart) {
		this.periodStart = periodStart;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public ContentPartner getContentPartner() {
		return this.contentPartner;
	}

	public void setContentPartner(ContentPartner contentPartner) {
		this.contentPartner = contentPartner;
	}

	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Video getVideo() {
		return this.video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

}