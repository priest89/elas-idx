package com.pirest.elas.idx.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Created by jongpark on 1/24/17.
 */
@Entity
@Table(name = "video_media_rendition")
public class VideoMediaRendition implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "video_media_rendition_id")
    private long videoMediaRenditionId;

    @Column(name = "video_bitrate_kbps")
    private Integer videoBitrateKbps;

    @Column(name = "max_video_bitrate_kbps")
    private Integer maxVideoBitrateKbps;

    @Column(name = "audio_bitrate_kbps")
    private Integer audioBitrateKbps;

    @Column(name = "video_codec")
    private String videoCodec;

    @Column(name = "audio_codec")
    private String audioCodec;

    @Column(name = "framerate")
    private Float framerate;

    @Column(name = "scan")
    private String scan;

    @Column(name = "aspect_ratio")
    private String aspectRatio;

    @Column(name = "width")
    private Integer width;

    @Column(name = "height")
    private Integer height;

    @Column(name = "chroma")
    private String chroma;

    @ManyToOne(optional = false)
    @JoinColumn(name = "video_media_id", nullable = false)
    private VideoMedia videoMedia;

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

    public VideoMediaRendition() {
    }

    public VideoMediaRendition(long videoMediaRenditionId) {
        this.videoMediaRenditionId = videoMediaRenditionId;
    }

    public long getVideoMediaRenditionId() {
        return videoMediaRenditionId;
    }

    public void setVideoMediaRenditionId(long videoMediaRenditionId) {
        this.videoMediaRenditionId = videoMediaRenditionId;
    }

    public VideoMedia getVideoMedia() {
        return videoMedia;
    }

    public void setVideoMedia(VideoMedia videoMedia) {
        this.videoMedia = videoMedia;
    }

    public Integer getVideoBitrateKbps() {
        return videoBitrateKbps;
    }

    public void setVideoBitrateKbps(Integer videoBitrateKbps) {
        this.videoBitrateKbps = videoBitrateKbps;
    }

    public Integer getMaxVideoBitrateKbps() {
        return maxVideoBitrateKbps;
    }

    public void setMaxVideoBitrateKbps(Integer maxVideoBitrateKbps) {
        this.maxVideoBitrateKbps = maxVideoBitrateKbps;
    }

    public Integer getAudioBitrateKbps() {
        return audioBitrateKbps;
    }

    public void setAudioBitrateKbps(Integer audioBitrateKbps) {
        this.audioBitrateKbps = audioBitrateKbps;
    }

    public String getVideoCodec() {
        return videoCodec;
    }

    public void setVideoCodec(String videoCodec) {
        this.videoCodec = videoCodec;
    }

    public String getAudioCodec() {
        return audioCodec;
    }

    public void setAudioCodec(String audioCodec) {
        this.audioCodec = audioCodec;
    }

    public Float getFramerate() {
        return framerate;
    }

    public void setFramerate(Float framerate) {
        this.framerate = framerate;
    }

    public String getScan() {
        return scan;
    }

    public void setScan(String scan) {
        this.scan = scan;
    }

    public String getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(String aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getChroma() {
        return chroma;
    }

    public void setChroma(String chroma) {
        this.chroma = chroma;
    }

    public Date getCreateDate() {
        return createDate;
    }


    public Date getLastmodified() {
        return lastmodified;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof VideoMediaRendition)) return false;
        VideoMediaRendition that = (VideoMediaRendition) object;
        return Objects.equals(videoMediaRenditionId, that.videoMediaRenditionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(videoMediaRenditionId);
    }
}
