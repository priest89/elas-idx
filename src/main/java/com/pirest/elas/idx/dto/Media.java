package com.pirest.elas.idx.dto;

import java.io.Serializable;

import com.pirest.elas.idx.dto.annotation.Mapping;

/**
 * Created by jongpark on 1/29/15.
 */
public class Media extends Document implements Serializable {
	private static final long serialVersionUID = 1L;
	@Mapping(fieldType = Mapping.FieldType.STRING, fieldIndex = Mapping.FieldIndex.NOT_ANALYZED)
	@Mapping.Id
	private String media_id;
	private String media_url;
	private String media_type;
	private Integer height;
	private Integer width;
	@Mapping(fieldType = Mapping.FieldType.STRING, fieldIndex = Mapping.FieldIndex.NOT_ANALYZED)
	private String resolution;

	public Media() {
	}

	public String getMedia_url() {
		return media_url;
	}

	public void setMedia_url(String media_url) {
		this.media_url = media_url;
	}

	public String getMedia_type() {
		return media_type;
	}

	public void setMedia_type(String media_type) {
		this.media_type = media_type;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

	@Override
	public String getId() {
		return media_id;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
}
