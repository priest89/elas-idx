package com.pirest.elas.idx.dto.query.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

/**
 * Created by jongpark on 1/27/17.
 */
public abstract class FieldFilter implements Filter {

    @JsonIgnore
    protected String field;

    protected FieldFilter(String field) {
        this.field = field;
    }

    @JsonValue
    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof FieldFilter)) return false;
        FieldFilter that = (FieldFilter) object;
        return Objects.equals(field, that.field);
    }

}
