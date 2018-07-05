package com.pirest.elas.idx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cut")
public class Cut {
	@Id
    @GeneratedValue
    @Column(name = "cut_id", insertable = false, updatable = false, nullable = false, unique = true)
    private int cutId;

    @Column(name = "cut")
    private String cut;

	public int getCutId() {
		return cutId;
	}

	public void setCutId(int cutId) {
		this.cutId = cutId;
	}

	public String getCut() {
		return cut;
	}

	public void setCut(String cut) {
		this.cut = cut;
	}
}
