package com.pirest.elas.idx.dto.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Mapping {
	String IGNORE_STRING = "ignore";

	FieldType fieldType() default FieldType.IGNORE;

	FieldIndex fieldIndex() default FieldIndex.IGNORE;

	enum FieldType {
		STRING("string"), NESTED("nested"), LONG("long"), INTEGER("integer"), FLOAT("float"), DOUBLE("double"), BOOLEAN(
				"boolean"), SHINGLE("shingle"), DATE("date"), IGNORE(IGNORE_STRING);

		private String name;

		FieldType(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		@Override
		public String toString() {
			return name;
		}
	}

	enum FieldIndex {
		ANALYZED("analyzed"), NOT_ANALYZED("not_analyzed"), IGNORE(IGNORE_STRING);

		private String name;

		FieldIndex(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		@Override
		public String toString() {
			return name;
		}
	}

	@Target(ElementType.FIELD)
	@Retention(RetentionPolicy.RUNTIME)
	@interface Id {

	}
}
