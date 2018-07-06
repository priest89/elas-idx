package com.pirest.elas.idx.dto.query.filter;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.pirest.elas.idx.util.Mapper;

/**
 * Created by jongpark on 1/30/17.
 */
public class NotFilterDeserializer extends StdDeserializer<NotFilter> {
	private ObjectMapper mapper = Mapper.mapper();

	public NotFilterDeserializer() {
		this(null);
	}

	public NotFilterDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public NotFilter deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		JsonNode node = jp.getCodec().readTree(jp);
		return new NotFilter(mapper.treeToValue(node, Filter.class));
	}
}
