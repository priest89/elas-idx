package com.pirest.elas.idx.dto.analysis;

import com.pirest.elas.idx.dto.filter.ShingleFilter;

public class ShingleAnalyzer extends BaseAnalyzer {
	public static final String DEFAULT_NAME = "shingle_analyzer";

	public ShingleAnalyzer(String name, String field) {
		super(DEFAULT_NAME, "shingle");
		setType("custom");
		setTokenizer("standard");
		setFilter(new String[] { "standard", "lowercase", ShingleFilter.DEFAULT_NAME });
	}
}
