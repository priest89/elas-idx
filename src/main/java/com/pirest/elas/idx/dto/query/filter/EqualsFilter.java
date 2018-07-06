package com.pirest.elas.idx.dto.query.filter;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Created by jongpark on 1/27/17.
 */
@JsonTypeName("equals")
public class EqualsFilter<T> extends FieldValueFilter<T> {

	public EqualsFilter(String field, T value) {
		super(field, value);
	}

	public EqualsFilter() {
		this(null, null);
	}
}
