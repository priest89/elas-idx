package com.pirest.elas.idx.dto.query.filter;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by jongpark on 1/27/17.
 */
@JsonTypeName("in")
public class InFilter<T> extends FieldValueFilter<List<T>> {

    public InFilter() {
        this(null, new ArrayList());
    }


    public InFilter(String field, Collection<? extends T> value) {
        super(field, new ArrayList<>(value));
    }

    public InFilter(String field, T... values) {
        super(field, Arrays.asList(values));
    }

    public InFilter in(T value) {
        this.value.add(value);
        return this;
    }

    public InFilter in(T... values) {
        this.value.addAll(Arrays.asList(values));
        return this;
    }
}
