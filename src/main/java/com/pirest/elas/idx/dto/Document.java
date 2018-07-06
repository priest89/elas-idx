package com.pirest.elas.idx.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.pirest.elas.idx.dto.annotation.Mapping;

/**
 * Created by jongpark on 1/16/15.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Document implements Serializable {
    private static final long serialVersionUID = 1L;

    @Mapping(fieldType = Mapping.FieldType.DATE)
    private String last_updated;

    public static String getType(Class<? extends Document> dtoClass) {
        return dtoClass.getSimpleName().toLowerCase();
    }


    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    @JsonIgnore
    public abstract String getId();

}
