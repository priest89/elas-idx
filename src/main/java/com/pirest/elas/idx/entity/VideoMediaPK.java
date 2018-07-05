package com.pirest.elas.idx.entity;

import java.io.Serializable;

public class VideoMediaPK implements Serializable {

	private static final long serialVersionUID = 1L;
	private long videoMediaId; 
	private long videoId; 
	private long videoMediaResolutionId; 
	private long videoMediaTypeId;
	
	public VideoMediaPK() {

	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (videoId ^ (videoId >>> 32));
		result = prime * result + (int) (videoMediaId ^ (videoMediaId >>> 32));
		result = prime * result + (int) (videoMediaResolutionId ^ (videoMediaResolutionId >>> 32));
		result = prime * result + (int) (videoMediaTypeId ^ (videoMediaTypeId >>> 32));
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
		VideoMediaPK other = (VideoMediaPK) obj;
		if (videoId != other.videoId)
			return false;
		if (videoMediaId != other.videoMediaId)
			return false;
		if (videoMediaResolutionId != other.videoMediaResolutionId)
			return false;
		if (videoMediaTypeId != other.videoMediaTypeId)
			return false;
		return true;
	}

	public long getVideoMediaId() {
		return videoMediaId;
	}
	public void setVideoMediaId(long videoMediaId) {
		this.videoMediaId = videoMediaId;
	}
	public long getVideoId() {
		return videoId;
	}
	public void setVideoId(long videoId) {
		this.videoId = videoId;
	}
	public long getVideoMediaResolutionId() {
		return videoMediaResolutionId;
	}
	public void setVideoMediaResolutionId(long videoMediaResolutionId) {
		this.videoMediaResolutionId = videoMediaResolutionId;
	}
	public long getVideoMediaTypeId() {
		return videoMediaTypeId;
	}
	public void setVideoMediaTypeId(long videoMediaTypeId) {
		this.videoMediaTypeId = videoMediaTypeId;
	}
	
	
}
