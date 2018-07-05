package com.pirest.elas.idx.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the RULES database table.
 * 
 */
@Entity
@Table(name = "rule") 
public class Rule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "rules_id")
	private long rulesId;

	@Column(name = "rule_name")
	private String ruleName;

	public Rule() {
	}

	public long getRulesId() {
		return this.rulesId;
	}

	public void setRulesId(long rulesId) {
		this.rulesId = rulesId;
	}

	public String getRuleName() {
		return this.ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

}