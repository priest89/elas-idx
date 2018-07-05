package com.pirest.elas.idx.entity;

import java.io.Serializable;

public class ChannelToVideoPK implements Serializable {

	private static final long serialVersionUID = 1L;
	private long channelId;
	private long videoId;
	
	public ChannelToVideoPK() {

	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (channelId ^ (channelId >>> 32));
		result = prime * result + (int) (videoId ^ (videoId >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChannelToVideoPK other = (ChannelToVideoPK) obj;
		if (channelId != other.channelId)
			return false;
		if (videoId != other.videoId)
			return false;
		return true;
	}
	public long getChannelId() {
		return channelId;
	}
	public void setChannelId(long channelId) {
		this.channelId = channelId;
	}
	public long getVideoId() {
		return videoId;
	}
	public void setVideoId(long videoId) {
		this.videoId = videoId;
	}
	
}
