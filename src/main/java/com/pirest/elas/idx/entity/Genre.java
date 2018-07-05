package com.pirest.elas.idx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue
    @Column(name = "genre_id", insertable = false, updatable = false, nullable = false, unique = true)
    private int genre_id;

    @Column(name = "genre")
    private String genre;


    public int getGenre_id() {
        return genre_id;
    }


    public String getGenre() {
        return genre;
    }
}
