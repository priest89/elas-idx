package com.pirest.elas.idx.dto.query.filter;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Created by jongpark on 1/27/17.
 */
@JsonTypeName("and")
public class AndFilter extends ListFilter {

	public AndFilter() {
		this(new ArrayList<Filter>());
	}

	public AndFilter(Collection<? extends Filter> c) {
		super(c);
	}

	public AndFilter and(Filter filter) {
		add(filter);
		return this;
	}
}
