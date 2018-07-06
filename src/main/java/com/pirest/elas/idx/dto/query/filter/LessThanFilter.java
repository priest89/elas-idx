package com.pirest.elas.idx.dto.query.filter;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Created by jongpark on 1/30/17.
 */
@JsonTypeName("lt")
public class LessThanFilter<T> extends FieldValueFilter {

    public LessThanFilter() {
        this(null, null);
    }

    public LessThanFilter(String field, Object value) {
        super(field, value);
    }
}
