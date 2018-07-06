package com.pirest.elas.idx.dto.filter;

public class ShingleFilter extends BaseFilter {

	public static final String DEFAULT_NAME = "shingle_filter";

	boolean output_unigram;
	private int min_shingle_size = 2;
	private int max_shingle_size = 3;

	public ShingleFilter(String name) {
		super(name);
		setType("shingle");
	}

	public boolean isOutput_unigram() {
		return output_unigram;
	}

	public void setOutput_unigram(boolean output_unigram) {
		this.output_unigram = output_unigram;
	}

	public int getMin_shingle_size() {
		return min_shingle_size;
	}

	public void setMin_shingle_size(int min_shingle_size) {
		this.min_shingle_size = min_shingle_size;
	}

	public int getMax_shingle_size() {
		return max_shingle_size;
	}

	public void setMax_shingle_size(int max_shingle_size) {
		this.max_shingle_size = max_shingle_size;
	}

}
