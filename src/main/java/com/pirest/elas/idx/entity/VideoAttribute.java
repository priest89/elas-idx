package com.pirest.elas.idx.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * 
 * Persistent class for VIDEO_ATTR table
 *
 */
@Entity
@Table(name="video_attr")
public class VideoAttribute implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="video_attr_id")
	private long videoAttributeId;
	
	@ManyToOne(cascade={CascadeType.REFRESH}, optional = false)
	@JoinColumn(name="video_id", nullable=false)
	private Video video;
	
	@OneToOne(cascade={CascadeType.PERSIST}, optional=false)
	@JoinColumn(name="attr_type_id", nullable=false)
	private AttributeType attributeType;
	
	@Column(name="video_attr_value", length=128)
	private String videoAttributeValue;
	
	public VideoAttribute() {}

	public long getVideoAttributeId() {
		return videoAttributeId;
	}

	public void setVideoAttributeId(long videoAttributeId) {
		this.videoAttributeId = videoAttributeId;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public AttributeType getAttributeType() {
		return attributeType;
	}

	public void setAttributeType(AttributeType attributeType) {
		this.attributeType = attributeType;
	}

	public String getVideoAttributeValue() {
		return videoAttributeValue;
	}

	public void setVideoAttributeValue(String videoAttributeValue) {
		this.videoAttributeValue = videoAttributeValue;
	}

}
