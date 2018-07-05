package com.pirest.elas.idx.entity;

import java.io.Serializable;

public class UserToImageSizePK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private long userId;
    private int imageSizeId;
    
    public UserToImageSizePK() {
		
	}
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (imageSizeId ^ (imageSizeId >>> 32));
		result = prime * result + (int) (userId ^ (userId >>> 32));
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
		UserToImageSizePK other = (UserToImageSizePK) obj;
		if (imageSizeId != other.imageSizeId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}


	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public int getImageSizeId() {
		return imageSizeId;
	}
	public void setImageSizeId(int imageSizeId) {
		this.imageSizeId = imageSizeId;
	}
}
