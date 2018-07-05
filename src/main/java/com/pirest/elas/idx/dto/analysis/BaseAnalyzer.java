package com.pirest.elas.idx.dto.analysis;

public abstract class BaseAnalyzer extends BaseAnalysis {

	private String tokenizer;

	private String[] filter;

	private String field;

	public BaseAnalyzer(String name, String field) {
		super(name);
		setType("string");
		this.field = field;
	}

	public String getTokenizer() {
		return tokenizer;
	}

	public void setTokenizer(String tokenizer) {
		this.tokenizer = tokenizer;
	}

	public String[] getFilter() {
		return filter;
	}

	public void setFilter(String[] filter) {
		this.filter = filter;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
}
