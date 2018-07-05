package com.pirest.elas.idx.entity;

import java.io.Serializable;

public class VideoToImageSizePK implements Serializable {
  
	private static final long serialVersionUID = 1L;
	private long videoId;
    private int imageSizeId;
    
    public VideoToImageSizePK() {
		
	}
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (imageSizeId ^ (imageSizeId >>> 32));
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
		VideoToImageSizePK other = (VideoToImageSizePK) obj;
		if (imageSizeId != other.imageSizeId)
			return false;
		if (videoId != other.videoId)
			return false;
		return true;
	}

	public long getVideoId() {
		return videoId;
	}
	public void setVideoId(long videoId) {
		this.videoId = videoId;
	}
	public int getImageSizeId() {
		return imageSizeId;
	}
	public void setImageSizeId(int imageSizeId) {
		this.imageSizeId = imageSizeId;
	}
    
}
