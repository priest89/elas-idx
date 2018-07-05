package com.pirest.elas.idx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "periodicity")
public class Periodicity {
  @Id
    @GeneratedValue
    @Column(name = "periodicity_id", insertable = false, updatable = false, nullable = false, unique = true)
    private int periodicityId;

    @Column(name = "periodicity")
    private String periodicity;

	public int getPeriodicityId() {
		return periodicityId;
	}

	public void setPeriodicityId(int periodicityId) {
		this.periodicityId = periodicityId;
	}

	public String getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(String periodicity) {
		this.periodicity = periodicity;
	}
}
