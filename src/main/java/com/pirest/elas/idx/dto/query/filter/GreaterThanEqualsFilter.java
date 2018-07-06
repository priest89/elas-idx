package com.pirest.elas.idx.dto.query.filter;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Created by jongpark on 1/30/17.
 */
@JsonTypeName("gte")
public class GreaterThanEqualsFilter<T> extends FieldValueFilter {

    public GreaterThanEqualsFilter() {
        this(null, null);
    }

    public GreaterThanEqualsFilter(String field, Object value) {
        super(field, value);
    }
}
