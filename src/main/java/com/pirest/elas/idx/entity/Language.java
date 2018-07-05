package com.pirest.elas.idx.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * The persistent class for the LANGUAGE database table.
 * 
 */
@Entity
@Table(name = "language") 
public class Language implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "language_id")
    private int languageId;

    @Column(name = "language_code")
    private String languageCode;


    public int getLanguageId() {
        return languageId;
    }


    public String getLanguageCode() {
        return languageCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Language)) return false;
        Language that = (Language) o;
        return Objects.equals(languageId, that.languageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(languageId);
    }
}