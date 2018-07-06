package com.pirest.elas.idx.dto.query;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by jongpark on 12/27/14.
 */
public class Sort {
	public static final Sort NEWEST = new Sort("date_publish", SortOrder.DESC);
	private String field;
	private SortOrder order;

	public Sort(String field, SortOrder order) {
		this.field = field;
		this.order = order;
	}

	public Sort() {
	}

	public SortOrder getOrder() {
		return order;
	}

	public void setOrder(SortOrder order) {
		this.order = order;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public enum SortOrder {
		ASC("asc"), DESC("desc");

		private String name;

		SortOrder(String name) {
			this.name = name;
		}

		@JsonCreator
		public static SortOrder forName(String name) {
			return valueOf(name.toUpperCase());
		}

		@JsonValue
		public String getName() {
			return name;
		}

		@Override
		public String toString() {
			return getName();
		}
	}

}
