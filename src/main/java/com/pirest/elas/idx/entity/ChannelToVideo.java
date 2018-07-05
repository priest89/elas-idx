package com.pirest.elas.idx.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="channel_to_video", uniqueConstraints= {@UniqueConstraint(columnNames={"channel_id", "video_id"})})
public class ChannelToVideo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ChannelToVideoId pk = new ChannelToVideoId();
	
	@MapsId("channelId")
	@JoinColumn(name="channel_id", nullable=false)
	@ManyToOne(cascade={CascadeType.REFRESH}, optional=false)
	private Channel channel;
	
	@MapsId("videoId")
	@JoinColumn(name="video_id", nullable=false)
	@ManyToOne(cascade={CascadeType.REFRESH}, optional=false)
	private Video video;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date", columnDefinition="DATETIME", insertable=false, updatable=false)
	private Date createDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="lastmodified", columnDefinition="DATETIME", insertable=false, updatable=false)
	private Date lastModified;

	@PrePersist
	public void onCreate() {
		Date d = new Date();
		this.setCreateDate(d);
		this.setLastModified(d);
	}
	
	@PreUpdate
	public void onUpdate() {
		this.setLastModified(new Date());
	}
	
	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
		this.pk.setChannelId(channel.getChannelId());
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
		this.pk.setVideoId(video.getVideoId());
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof ChannelToVideo) {
			if (pk.equals(((ChannelToVideo) o).pk))
				return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
        return pk.hashCode();
	}

}
