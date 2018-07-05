package com.pirest.elas.idx.dto.analysis;

public abstract class BaseAnalysis {
	private String name;
	private String type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BaseAnalysis(String name) {
		super();
		this.name = name;
	}
}
