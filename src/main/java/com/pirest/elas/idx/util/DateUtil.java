package com.pirest.elas.idx.util;

import java.util.Date;

import org.apache.commons.lang3.time.FastDateFormat;

public class DateUtil {
	public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
	private static final FastDateFormat FORMATTER = FastDateFormat.getInstance(DATE_FORMAT);

	public static String format(Date date) {
		return FORMATTER.format(date);
	}

	public static Date parse(final String date) {
		if (date == null)
			return null;
		try {
			return FORMATTER.parse(date);
		} catch (Exception e) {
			return null;
		}
	}

}
