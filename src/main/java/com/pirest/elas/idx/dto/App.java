package com.pirest.elas.idx.dto;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pirest.elas.idx.dto.annotation.Mapping;

/**
 * Created by jongpark on 11/8/16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class App extends Document implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long app_id;
	@Mapping(fieldType = Mapping.FieldType.STRING, fieldIndex = Mapping.FieldIndex.NOT_ANALYZED)
	private String app_name;

	public App(Long app_id, String app_name) {
		this.app_id = app_id;
		this.app_name = app_name;
	}

	public App() {
	}

	public Long getApp_id() {
		return app_id;
	}

	public void setApp_id(Long app_id) {
		this.app_id = app_id;
	}

	public String getApp_name() {
		return app_name;
	}

	public void setApp_name(String app_name) {
		this.app_name = app_name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof App))
			return false;
		App app = (App) o;
		return Objects.equals(app_id, app.app_id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(app_id);
	}

	@Override
	public String getId() {
		return app_id.toString();
	}
}
