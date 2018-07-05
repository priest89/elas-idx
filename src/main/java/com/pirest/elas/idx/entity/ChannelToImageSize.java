package com.pirest.elas.idx.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "channel_to_image_size")
@IdClass(value=ChannelToImageSizePK.class)
public class ChannelToImageSize {

    @Id
	@Column(name = "channel_id", insertable = false, updatable = false)
    private long channelId;
    
    @Id
    @Column(name = "image_size_id", insertable = false, updatable = false)
    private int imageSizeId;
    
    
    @Column(name = "upscaled")
    private boolean upScaled;

    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", columnDefinition = "DATETIME", insertable = false, updatable = false)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastmodified", columnDefinition = "DATETIME", insertable = false, updatable = false)
    private Date lastmodified;
    
    
    @ManyToOne(cascade = {CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "image_size_id", nullable = false, insertable = false, updatable = false)
    private ChannelImageSize imageSize;

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

	public long getChannelId() {
		return channelId;
	}

	public void setChannelId(long channelId) {
		this.channelId = channelId;
	}

	public int getImageSizeId() {
		return imageSizeId;
	}

	public void setImageSizeId(int imageSizeId) {
		this.imageSizeId = imageSizeId;
	}

	public boolean isUpScaled() {
		return upScaled;
	}

	public void setUpScaled(boolean upScaled) {
		this.upScaled = upScaled;
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

	public ChannelImageSize getImageSize() {
		return imageSize;
	}

	public void setImageSize(ChannelImageSize imageSize) {
		this.imageSize = imageSize;
	}
   
}

