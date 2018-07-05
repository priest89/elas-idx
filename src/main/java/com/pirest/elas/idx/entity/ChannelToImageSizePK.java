package com.pirest.elas.idx.entity;

import java.io.Serializable;

public class ChannelToImageSizePK implements Serializable {
  
	private static final long serialVersionUID = 1L;
	private long channelId;
    private int imageSizeId;
    
    public ChannelToImageSizePK() {
		
	}
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (imageSizeId ^ (imageSizeId >>> 32));
		result = prime * result + (int) (channelId ^ (channelId >>> 32));
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
		ChannelToImageSizePK other = (ChannelToImageSizePK) obj;
		if (imageSizeId != other.imageSizeId)
			return false;
		if (channelId != other.channelId)
			return false;
		return true;
	}


	public long getChannelId() {
		return channelId;
	}
	public void setChannelId(long channelId) {
		this.channelId = channelId;
	}
	public int getImageSizeId() {
		return imageSizeId;
	}
	public void setImageSizeId(int imageSizeId) {
		this.imageSizeId = imageSizeId;
	}
    
}
