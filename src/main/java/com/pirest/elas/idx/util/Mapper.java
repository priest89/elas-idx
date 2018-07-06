package com.pirest.elas.idx.util;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.pirest.elas.idx.dto.query.filter.CustomUnwrappingSerializer;
import com.pirest.elas.idx.dto.query.filter.NotFilter;

/**
 * Created by jongpark on 1/30/17.
 */
public class Mapper {

	private static final ObjectMapper mapper = new ObjectMapper();

	static {
		mapper.configure(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS, false);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		mapper.registerModule(new Module() {
			@Override
			public String getModuleName() {
				return "rule";
			}

			@Override
			public Version version() {
				return Version.unknownVersion();
			}

			@Override
			public void setupModule(SetupContext context) {
				context.addBeanSerializerModifier(new BeanSerializerModifier() {
					@Override
					public JsonSerializer<?> modifySerializer(SerializationConfig config, BeanDescription beanDesc,
							JsonSerializer<?> serializer) {
						if (beanDesc.getBeanClass().equals(NotFilter.class)) {
							return new CustomUnwrappingSerializer((BeanSerializerBase) serializer, NameTransformer.NOP);
						}
						return serializer;
					}
				});
			}
		});
	}

	public static String toJson(final Object object) throws JsonProcessingException {
		return mapper.writeValueAsString(object);
	}

	public static <T> T toPojo(final String json, final Class<T> valueType) throws IOException {
		return mapper.readValue(json, valueType);
	}

	public static <T> T toPojo(final byte[] bytes, final Class<T> valueType) throws IOException {
		return mapper.readValue(bytes, valueType);
	}

	public static String toPrettyJson(final Object object) throws JsonProcessingException {
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
	}

	public static ObjectMapper mapper() {
		return mapper;
	}
}
