package com.pirest.elas.idx.dto.analysis;

public class LowerCaseAnalyzer extends BaseAnalyzer {
	public static final String DEFAULT_NAME = "lowercase_analyzer";

	public LowerCaseAnalyzer(String name, String field) {
		super(DEFAULT_NAME, "lowercase");
		setTokenizer("keyword");
		setFilter(new String[] { "lowercase" });
	}

}
