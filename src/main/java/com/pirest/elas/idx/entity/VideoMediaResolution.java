package com.pirest.elas.idx.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the VIDEO_MEDIA_RESOLUTION database table.
 * 
 */
@Entity
@Table(name = "video_media_resolution")
public class VideoMediaResolution implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "video_media_resolution_id")
	private long videoMediaResolutionId;

    @Column(nullable = false)
	private int height;

    @Column(nullable = false)
    private int width;

	@Column(name = "resolution_name", length = 45, nullable = false)
	private String resolutionName;

	//bi-directional many-to-one association to VideoMedia
	@OneToMany(mappedBy = "videoMediaResolution", cascade = {CascadeType.REFRESH})
	private List<VideoMedia> videoMedias;

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

    public VideoMediaResolution() {
	}

	public long getVideoMediaResolutionId() {
		return this.videoMediaResolutionId;
	}

	public void setVideoMediaResolutionId(long videoMediaResolutionId) {
		this.videoMediaResolutionId = videoMediaResolutionId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Date getLastmodified() {
		return this.lastmodified;
	}

	public void setLastmodified(Date lastmodified) {
		this.lastmodified = lastmodified;
	}

	public String getResolutionName() {
		return this.resolutionName;
	}

	public void setResolutionName(String resolutionName) {
		this.resolutionName = resolutionName;
	}

	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public List<VideoMedia> getVideoMedias() {
		return this.videoMedias;
	}

	public void setVideoMedias(List<VideoMedia> videoMedias) {
		this.videoMedias = videoMedias;
	}

	public VideoMedia addVideoMedia(VideoMedia videoMedia) {
		getVideoMedias().add(videoMedia);
		videoMedia.setVideoMediaResolution(this);

		return videoMedia;
	}

	public VideoMedia removeVideoMedia(VideoMedia videoMedia) {
		getVideoMedias().remove(videoMedia);
		videoMedia.setVideoMediaResolution(null);

		return videoMedia;
	}

}