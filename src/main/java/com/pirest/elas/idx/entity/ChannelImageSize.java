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

@Entity
@Table(name = "channel_image_size")
public class ChannelImageSize implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "image_size_id")
    private int imageSizeId;
	
    @Column(name = "width")
    private int width;
    
    @Column(name = "height")
    private int height;

    @Column(name = "type", nullable = false, length = 45)
    private String type;

    @Column(name = "shape", nullable = false, length = 45)
    private String shape;
    
    @Column(name = "extension", nullable = false, length = 10)
    private String extension;

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

    public ChannelImageSize() {
    }

    public ChannelImageSize(int imageSizeId, int width, int height, String type, String shape, String extension) {
        this.imageSizeId = imageSizeId;
        this.width = width;
        this.height = height;
        this.type = type;
        this.shape = shape;
        this.extension = extension;
    }

    public String getExtension() {
  		return extension;
  	}

  	public void setExtension(String extension) {
  		this.extension = extension;
  	}
  	
    public int getImageSizeId() {
		return imageSizeId;
	}

	public void setImageSizeId(int imageSizeId) {
		this.imageSizeId = imageSizeId;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
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
