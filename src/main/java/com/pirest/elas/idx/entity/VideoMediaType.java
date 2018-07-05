package com.pirest.elas.idx.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the VIDEO_MEDIA_TYPE database table.
 * 
 */
@Entity
@Table(name = "video_media_type")
public class VideoMediaType implements Serializable {
	private static final long serialVersionUID = 1L;

    /*public static enum Types {
        ALL(0L, ""),
        HLS(1L, "application/x-mpegURL"),
        H264(2L, "video/mp4"),
        HTML5(3L, ""),
        FLASH(4L, "");

        private long mediaTypeId;
        private String mediaType;

        private Types(long mediaTypeId, String mediaType) {
            this.mediaTypeId = mediaTypeId;
            this.mediaType = mediaType;
        }

        public long getVideoMediaTypeId() {
            return this.mediaTypeId;
        }

        public String getMimeType() {
            return this.mediaType;
        }

        public static Types fromVideoMedia(VideoMedia videoMedia) {
            return fromVideoMediaTypeId(videoMedia.getVideoMediaType().getVideoMediaTypeId());
        }

        public static Types fromVideoMediaTypeId(long mediaTypeId) {
            for (Types type : values()) {
                if (type.getVideoMediaTypeId() == mediaTypeId) {
                    return type;
                }
            }
            return null;
        }

        public static Types fromVideoMediaType(VideoMediaType videoMediaType) {
            for (Types type : values()) {
                if (type.getVideoMediaTypeId() == videoMediaType.getVideoMediaTypeId()) {
                    return type;
                }
            }
            return null;
        }
    }*/

	@Id
	@Column(name = "video_media_type_id")
	private long videoMediaTypeId;

    @Column(name = "media_type", length = 255, nullable = false)
    private String mediaType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", columnDefinition = "DATETIME", insertable = false, updatable = false)
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastmodified", columnDefinition = "DATETIME", insertable = false, updatable = false)
	private Date lastmodified;

	//bi-directional many-to-one association to VideoMedia
	@OneToMany(mappedBy = "videoMediaType", cascade = {CascadeType.REFRESH})
	private List<VideoMedia> videoMedias;

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

    public VideoMediaType() {
	}

	public long getVideoMediaTypeId() {
		return this.videoMediaTypeId;
	}

	public void setVideoMediaTypeId(long videoMediaTypeId) {
		this.videoMediaTypeId = videoMediaTypeId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastmodified() {
		return this.lastmodified;
	}

	public void setLastmodified(Date lastmodified) {
		this.lastmodified = lastmodified;
	}

	public String getMediaType() {
		return this.mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public List<VideoMedia> getVideoMedias() {
		return this.videoMedias;
	}

	public void setVideoMedias(List<VideoMedia> videoMedias) {
		this.videoMedias = videoMedias;
	}

	public VideoMedia addVideoMedia(VideoMedia videoMedia) {
		getVideoMedias().add(videoMedia);
		videoMedia.setVideoMediaType(this);

		return videoMedia;
	}

	public VideoMedia removeVideoMedia(VideoMedia videoMedia) {
		getVideoMedias().remove(videoMedia);
		videoMedia.setVideoMediaType(null);

		return videoMedia;
	}

}