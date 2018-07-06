package com.pirest.elas.idx.dto.query.filter;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Created by jongpark on 1/27/17.
 */
@JsonTypeName("contains")
public class ContainsFilter<T> extends FieldValueFilter<T> {

    public ContainsFilter() {
        this(null, null);
    }

    public ContainsFilter(String field, T value) {
        super(field, value);
    }
}
