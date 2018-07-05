package com.pirest.elas.idx.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MapperUtil {
	private static final ObjectMapper mapper = new ObjectMapper();

	public static final Logger LOGGER = LoggerFactory.getLogger(MapperUtil.class);

	public static String toJson(Object obj) {
		try {
			return mapper.writeValueAsString(obj);
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
		}
		return null;
	}
}
