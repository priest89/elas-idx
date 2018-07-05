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
 * The persistent class for the REGION database table.
 * 
 */
@Entity
@Table(name = "region") 
public class Region implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "region_id")
	private long regionId;

    @Column(length = 255, nullable = false)
	private String region;

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

	public Region() {
	}

	public long getRegionId() {
		return this.regionId;
	}

	public void setRegionId(long regionId) {
		this.regionId = regionId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public Date getLastmodified() {
		return this.lastmodified;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

}