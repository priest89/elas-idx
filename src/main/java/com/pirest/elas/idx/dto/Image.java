package com.pirest.elas.idx.dto;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pirest.elas.idx.dto.annotation.Mapping;

/**
 * Created by jongpark on 8/15/16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Image extends Document implements Serializable {
	private static final long serialVersionUID = 1L;
	@Mapping(fieldType = Mapping.FieldType.INTEGER)
	private Integer width;
	@Mapping(fieldType = Mapping.FieldType.INTEGER)
	private Integer height;
	@Mapping(fieldType = Mapping.FieldType.STRING, fieldIndex = Mapping.FieldIndex.NOT_ANALYZED)
	private String type;
	@Mapping(fieldType = Mapping.FieldType.STRING, fieldIndex = Mapping.FieldIndex.NOT_ANALYZED)
	private String shape;
	@Mapping(fieldType = Mapping.FieldType.STRING, fieldIndex = Mapping.FieldIndex.NOT_ANALYZED)
	private String extension;

	public Image() {
	}

	public Image(int width, int height, String type, String shape, String extension) {
		this.width = width;
		this.height = height;
		this.type = type;
		this.shape = shape;
		this.extension = extension;
	}

	@Override
	public String getId() {
		return toString();
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (!(object instanceof Image))
			return false;
		Image image = (Image) object;
		return Objects.equals(width, image.width) && Objects.equals(height, image.height)
				&& Objects.equals(type, image.type) && Objects.equals(shape, image.shape)
				&& Objects.equals(extension, image.extension);
	}

	@Override
	public int hashCode() {
		return Objects.hash(width, height, type, shape, extension);
	}
}
