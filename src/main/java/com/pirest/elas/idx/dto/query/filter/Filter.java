package com.pirest.elas.idx.dto.query.filter;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;

/**
 * Created by jongpark on 1/27/17.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes({
        @JsonSubTypes.Type(value = AndFilter.class, name = "and"),
        @JsonSubTypes.Type(value = OrFilter.class, name = "or"),
        @JsonSubTypes.Type(value = NotFilter.class, name = "not"),
        @JsonSubTypes.Type(value = EqualsFilter.class, name = "equals"),
        @JsonSubTypes.Type(value = ExistsFilter.class, name = "exists"),
        @JsonSubTypes.Type(value = ContainsFilter.class, name = "contains"),
        @JsonSubTypes.Type(value = InFilter.class, name = "in"),
        @JsonSubTypes.Type(value = LessThanEqualsFilter.class, name = "lte"),
        @JsonSubTypes.Type(value = LessThanFilter.class, name = "lt"),
        @JsonSubTypes.Type(value = GreaterThanEqualsFilter.class, name = "gte"),
        @JsonSubTypes.Type(value = GreaterThanFilter.class, name = "gt"),
        @JsonSubTypes.Type(value = RegexFilter.class, name = "regex")
})
public interface Filter extends Serializable {

}
