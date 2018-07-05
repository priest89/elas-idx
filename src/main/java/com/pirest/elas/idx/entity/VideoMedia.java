package com.pirest.elas.idx.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


/**
 * The persistent class for the VIDEO_MEDIA database table.
 */
@Entity
@Table(name = "video_media")
public class VideoMedia implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "video_media_id")
    private long videoMediaId;

    @Column(name = "video_media_guid")
    private String videoMediaGuid;

    @Column(name = "media_url", length = 2048, nullable = false)
    private String mediaUrl;

    //bi-directional many-to-one association to Video
    @ManyToOne(optional = false)
    @JoinColumn(name = "video_id", nullable = false)
    private Video video;

    //bi-directional many-to-one association to VideoMediaResolution
    @ManyToOne(cascade = {CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "video_media_resolution_id", nullable = false)
    private VideoMediaResolution videoMediaResolution;

    //bi-directional many-to-one association to VideoMediaTypeRepository
    @ManyToOne(cascade = {CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "video_media_type_id", nullable = false)
    private VideoMediaType videoMediaType;

    @OneToMany(mappedBy = "videoMedia", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<VideoMediaRendition> videoMediaRenditions = new ArrayList<>();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", columnDefinition = "DATETIME", insertable = false, updatable = false)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastmodified", columnDefinition = "DATETIME", insertable = false, updatable = false)
    private Date lastmodified;

    @Column(name = "is_internal", columnDefinition = "TINYINT(1)", nullable = false)
    private boolean isInternal = false;

    @Column(name = "media_class_name")
    private String mediaClassName;

    @Column(name = "delivery")
    private String delivery;

    @Column(name = "hls_segment_length")
    private Integer hlsSegmentLength;

    public VideoMedia() {
    }

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

    public long getVideoMediaId() {
        return this.videoMediaId;
    }

    public void setVideoMediaId(long videoMediaId) {
        this.videoMediaId = videoMediaId;
    }

    public String getVideoMediaGuid() {
        return videoMediaGuid;
    }

    public void setVideoMediaGuid(String videoMediaGuid) {
        this.videoMediaGuid = videoMediaGuid;
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

    public String getMediaUrl() {
        return this.mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public Video getVideo() {
        return this.video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public VideoMediaResolution getVideoMediaResolution() {
        return this.videoMediaResolution;
    }

    public void setVideoMediaResolution(VideoMediaResolution videoMediaResolution) {
        this.videoMediaResolution = videoMediaResolution;
    }

    public List<VideoMediaRendition> getVideoMediaRenditions() {
        return videoMediaRenditions;
    }

    public void setVideoMediaRenditions(List<VideoMediaRendition> videoMediaRenditions) {
        this.videoMediaRenditions = videoMediaRenditions;
    }

    public boolean addVideoMediaRendition(VideoMediaRendition videoMediaRendition) {
        videoMediaRendition.setVideoMedia(this);
        return videoMediaRenditions.add(videoMediaRendition);

    }

    public boolean removeVideoMediaRendition(VideoMediaRendition videoMediaRendition) {
        videoMediaRendition.setVideoMedia(null);
        return this.videoMediaRenditions.remove(videoMediaRendition);
    }

    public void clearVideoMediaRenditions() {
        for (Iterator<VideoMediaRendition> iterator = videoMediaRenditions.iterator(); iterator.hasNext(); ) {
            VideoMediaRendition videoMediaRendition = iterator.next();
            videoMediaRendition.setVideoMedia(null);
            iterator.remove();
        }
    }



    public VideoMediaType getVideoMediaType() {
        return this.videoMediaType;
    }

    public void setVideoMediaType(VideoMediaType videoMediaType) {
        this.videoMediaType = videoMediaType;
    }

    public boolean isInternal() {
        return isInternal;
    }

    public void setInternal(boolean isInternal) {
        this.isInternal = isInternal;
    }


    public String getMediaClassName() {
        return mediaClassName;
    }

    public void setMediaClassName(String mediaClassName) {
        this.mediaClassName = mediaClassName;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public Integer getHlsSegmentLength() {
        return hlsSegmentLength;
    }

    public void setHlsSegmentLength(Integer hlsSegmentLength) {
        this.hlsSegmentLength = hlsSegmentLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VideoMedia)) return false;
        VideoMedia that = (VideoMedia) o;
        return Objects.equals(mediaUrl, that.mediaUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mediaUrl);
    }
}