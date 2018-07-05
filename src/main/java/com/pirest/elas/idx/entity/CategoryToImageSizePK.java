package com.pirest.elas.idx.entity;

import java.io.Serializable;

public class CategoryToImageSizePK implements Serializable {
  
	private static final long serialVersionUID = 1L;
	private long categoryId;
    private int imageSizeId;
    
    public CategoryToImageSizePK() {
		
	}
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (imageSizeId ^ (imageSizeId >>> 32));
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
		CategoryToImageSizePK other = (CategoryToImageSizePK) obj;
		if (imageSizeId != other.imageSizeId)
			return false;
		if (categoryId != other.categoryId)
			return false;
		return true;
	}


	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public int getImageSizeId() {
		return imageSizeId;
	}
	public void setImageSizeId(int imageSizeId) {
		this.imageSizeId = imageSizeId;
	}
    
}
