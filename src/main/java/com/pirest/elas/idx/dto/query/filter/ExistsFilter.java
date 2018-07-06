package com.pirest.elas.idx.dto.query.filter;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Created by jongpark on 1/27/17.
 */
@JsonTypeName("exists")
public class ExistsFilter extends FieldFilter {

    public ExistsFilter(String field) {
        super(field);
    }

    public ExistsFilter() {
        this(null);
    }


}
