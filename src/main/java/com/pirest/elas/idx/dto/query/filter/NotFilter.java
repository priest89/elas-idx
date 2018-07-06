package com.pirest.elas.idx.dto.query.filter;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Created by jongpark on 1/27/17.
 */
@JsonDeserialize(using = NotFilterDeserializer.class)
public class NotFilter implements Filter {

    @JsonUnwrapped
    private Filter filter;

    public NotFilter() {
        this(null);
    }

    public NotFilter(Filter filter) {
        this.filter = filter;
    }

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

}
