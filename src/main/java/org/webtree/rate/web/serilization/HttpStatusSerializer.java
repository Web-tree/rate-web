package org.webtree.rate.web.serilization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.http.HttpStatus;

import java.io.IOException;

/**
 * @author Max
 *         Created on 8/28/2016.
 */
public class HttpStatusSerializer extends StdSerializer<HttpStatus> {
    public HttpStatusSerializer() {
        this(null);
    }

    public HttpStatusSerializer(Class<HttpStatus> t) {
        super(t);
    }

    @Override
    public void serialize(HttpStatus value, JsonGenerator generator, SerializerProvider serializerProvider) throws IOException {
        generator.writeStartObject();
        generator.writeFieldName("value");
        generator.writeNumber(value.value());
        generator.writeFieldName("reasonPhrase");
        generator.writeString(value.getReasonPhrase());
        generator.writeEndObject();
    }
}
