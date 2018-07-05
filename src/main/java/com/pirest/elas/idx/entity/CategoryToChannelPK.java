package com.pirest.elas.idx.entity;

import java.io.Serializable;

public class CategoryToChannelPK implements Serializable {

	private static final long serialVersionUID = 1L;
	private long channelId;
	private long categoryId;
	
	public CategoryToChannelPK() {

	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (channelId ^ (channelId >>> 32));
		result = prime * result + (int) (categoryId ^ (categoryId >>> 32));
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
		CategoryToChannelPK other = (CategoryToChannelPK) obj;
		if (channelId != other.channelId)
			return false;
		if (categoryId != other.categoryId)
			return false;
		return true;
	}
	public long getChannelId() {
		return channelId;
	}
	public void setChannelId(long channelId) {
		this.channelId = channelId;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	
}
