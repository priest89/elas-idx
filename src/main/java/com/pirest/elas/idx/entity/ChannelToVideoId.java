package com.pirest.elas.idx.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ChannelToVideoId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name="channel_id")
	private Long channelId;
	
	@Column(name="video_id")
	private Long videoId;

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

	public Long getVideoId() {
		return videoId;
	}

	public void setVideoId(Long videoId) {
		this.videoId = videoId;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof ChannelToVideoId) {
			ChannelToVideoId other = (ChannelToVideoId)o;
			if (other.getChannelId() == this.getChannelId() && other.getVideoId() == this.getVideoId())
				return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int result = channelId.hashCode();
		return 31 * result + videoId.hashCode();
	}
}
