package com.pirest.elas.idx.dto.query.filter;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.impl.UnwrappingBeanSerializer;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import com.fasterxml.jackson.databind.util.NameTransformer;

/**
 * Created by jongpark on 1/30/17.
 */
public class CustomUnwrappingSerializer extends UnwrappingBeanSerializer {
	public CustomUnwrappingSerializer(BeanSerializerBase src, NameTransformer transformer) {
		super(src, transformer);
	}

	@Override
	public JsonSerializer<Object> unwrappingSerializer(NameTransformer transformer) {
		return new CustomUnwrappingSerializer(this, transformer);
	}

	@Override
	protected void serializeFields(Object bean, JsonGenerator jgen, SerializerProvider provider) throws IOException {
		if (bean instanceof NotFilter) {
			jgen.writeStartObject();
			jgen.writeObjectField("not", ((NotFilter) bean).getFilter());
			jgen.writeEndObject();
		}
	}

	@Override
	public boolean isUnwrappingSerializer() {
		return true;
	}
}
