package com.pirest.elas.idx.dto.query.filter;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Created by jongpark on 1/27/17.
 */
@JsonTypeName("or")
public class OrFilter extends ListFilter {

    public OrFilter() {
        this(new ArrayList<Filter>());
    }

    public OrFilter(Collection<? extends Filter> c) {
        super(c);
    }

    public OrFilter or(Filter filter) {
        add(filter);
        return this;
    }
}
