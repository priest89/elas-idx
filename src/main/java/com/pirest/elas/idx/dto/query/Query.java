package com.pirest.elas.idx.dto.query;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pirest.elas.idx.dto.query.filter.Filter;

public class Query {
	private String[] fields;
	private String query;
	private Filter filter;
	private Sort sort;
	private String[] include;
	private String[] exclude;
	private Integer offset;
	private Integer size;

	@JsonCreator
	public Query(@JsonProperty("query") String query) {
		this.query = query;
	}

	public String[] getFields() {
		return fields;
	}

	public void setFields(String... fields) {
		if (fields != null && fields[0] != null) {
			this.fields = fields;
		}
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public Filter getFilter() {
		return filter;
	}

	public void setFilter(Filter filter) {
		this.filter = filter;
	}

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

	public String[] getInclude() {
		return include;
	}

	public void setInclude(String... include) {
		this.include = include;
	}

	public String[] getExclude() {
		return exclude;
	}

	public void setExclude(String... exclude) {
		this.exclude = exclude;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Query fields(String... fields) {
		this.fields = fields;
		return this;
	}

	public Query filter(Filter filter) {
		this.filter = filter;
		return this;
	}

	public Query sort(Sort sort) {
		this.sort = sort;
		return this;
	}

	public Query includeFields(String... fields) {
		this.include = fields;
		return this;
	}

	public Query excludeFields(String... fields) {
		this.exclude = fields;
		return this;
	}

	public Query offset(Integer offset) {
		this.offset = offset;
		return this;
	}

	public Query size(Integer size) {
		this.size = size;
		return this;
	}
}
