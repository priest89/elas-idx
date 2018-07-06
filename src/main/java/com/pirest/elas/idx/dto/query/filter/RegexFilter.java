package com.pirest.elas.idx.dto.query.filter;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Created by jongpark on 2/9/17.
 */
@JsonTypeName("regex")
public class RegexFilter extends FieldValueFilter<String> {

	public RegexFilter() {
		this(null, null);
	}

	public RegexFilter(String field, String value) {
		super(field, value);
	}
}
