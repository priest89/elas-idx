package com.pirest.elas.idx.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.pirest.elas.idx.dto.analysis.LowerCaseAnalyzer;
import com.pirest.elas.idx.dto.annotation.Mapping;

/**
 * Created by jongpark on 1/16/15.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Category extends Document implements Serializable {
	private static final long serialVersionUID = 1L;

	@Mapping(fieldType = Mapping.FieldType.STRING, fieldIndex = Mapping.FieldIndex.NOT_ANALYZED)
	@Mapping.Id
	private String category_id;
	@Mapping(fieldType = Mapping.FieldType.STRING, fieldIndex = Mapping.FieldIndex.NOT_ANALYZED)
	private String category_guid;
	@Mapping(fieldType = Mapping.FieldType.STRING, analyzer = LowerCaseAnalyzer.class)
	private String title;
	@Mapping(fieldType = Mapping.FieldType.STRING, fieldIndex = Mapping.FieldIndex.NOT_ANALYZED, analyzer = LowerCaseAnalyzer.class)
	private String label;
	@Mapping(fieldType = Mapping.FieldType.LONG)
	private Long app_id;
	@Mapping(fieldType = Mapping.FieldType.NESTED)
	private List<Image> images;

	public Category(String category_id) {
		this.category_id = category_id;
	}

	public Category(String category_id, String title, String label, Long app_id) {
		this.category_id = category_id;
		this.title = title;
		this.label = label;
		this.app_id = app_id;
	}

	public Category() {
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Long getApp_id() {
		return app_id;
	}

	public void setApp_id(Long app_id) {
		this.app_id = app_id;
	}

	public String getCategory_guid() {
		return category_guid;
	}

	public void setCategory_guid(String category_guid) {
		this.category_guid = category_guid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Category))
			return false;

		Category category = (Category) o;

		return category_id.equals(category.getCategory_id());

	}

	@Override
	public int hashCode() {
		return category_id.hashCode();
	}

	@Override
	@JsonIgnore
	public String getId() {
		return category_id;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}
}
