package com.pirest.elas.idx.dto.query.filter;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by jongpark on 1/27/17.
 */
public abstract class FieldValueFilter<T> implements Filter {

    @JsonIgnore
    protected String field;
    @JsonIgnore
    protected T value;

    protected FieldValueFilter() {
        this(null, null);
    }

    protected FieldValueFilter(final String field, final T value) {
        this.field = field;
        this.value = value;
    }


    public T getValue() {
        return value;
    }

    public void setValue(final T value) {
        this.value = value;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @JsonAnySetter
    public void setFieldAndValue(final String field, final T value) {
        this.field = field;
        this.value = value;
    }

    @JsonAnyGetter
    private Map<String, T> getProperty() {
        HashMap<String, T> map = new HashMap<>();
        if (field != null) {
            map.put(field, value);
        }
        return map;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof FieldValueFilter)) return false;
        if (!super.equals(object)) return false;
        FieldValueFilter that = (FieldValueFilter) object;
        return Objects.equals(value, that.value);
    }

}
