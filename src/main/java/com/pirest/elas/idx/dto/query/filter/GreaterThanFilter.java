package com.pirest.elas.idx.dto.query.filter;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Created by jongpark on 1/30/17.
 */
@JsonTypeName("gt")
public class GreaterThanFilter<T> extends FieldValueFilter {

    public GreaterThanFilter() {
        this(null, null);
    }

    public GreaterThanFilter(String field, Object value) {
        super(field, value);
    }
}
