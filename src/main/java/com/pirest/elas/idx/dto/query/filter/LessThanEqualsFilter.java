package com.pirest.elas.idx.dto.query.filter;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Created by jongpark on 1/30/17.
 */
@JsonTypeName("lte")
public class LessThanEqualsFilter<T> extends FieldValueFilter {

    public LessThanEqualsFilter() {
        this(null, null);
    }

    public LessThanEqualsFilter(String field, Object value) {
        super(field, value);
    }
}
