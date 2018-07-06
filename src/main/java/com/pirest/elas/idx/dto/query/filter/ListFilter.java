package com.pirest.elas.idx.dto.query.filter;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by jongpark on 1/27/17.
 */
public abstract class ListFilter extends ArrayList<Filter> implements Filter {

    protected ListFilter(Collection<? extends Filter> c) {
        super(c);
    }


}
