package org.grozeille.proto;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;


import com.dyuproject.protostuff.JsonIOUtil;
import com.dyuproject.protostuff.Schema;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.Message;
import com.google.protobuf.Message.Builder;

@Provider
@Consumes({AlternateMediaType.APPLICATION_XPROTOBUF})
@Produces({AlternateMediaType.APPLICATION_XPROTOBUF})
public class ProtobuffJacksonJaxbJsonProvider extends JacksonJaxbJsonProvider {

    Map<Class<? extends Builder>, Schema<?>> protoReadSchemas;
    Map<Class<? extends Message>, Schema<?>> protoWriteSchemas;
    boolean useNumericFields;

    public ProtobuffJacksonJaxbJsonProvider() {
        super();
        this.protoReadSchemas = new HashMap<Class<? extends Builder>, Schema<?>>();
        this.protoWriteSchemas = new HashMap<Class<? extends Message>, Schema<?>>();
        this.useNumericFields = false;
    }

    public <T extends Builder> void registerProtoReadSchema(Class<T> m, Schema<T> readSchema) {
        protoReadSchemas.put(m, readSchema);
    }

    public <T extends Message> void registerProtoWriteSchema(Class<T> m, Schema<T> writeSchema) {
        protoWriteSchemas.put(m, writeSchema);
    }

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        System.out.println("MATHIAS: "+type);
        return protoReadSchemas.containsKey(type)
                || super.isReadable(type, genericType, annotations, mediaType);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public Object readFrom(Class<Object> type, Type genericType, Annotation[] annotations, MediaType mediaType,
                           MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException {
        Schema<?> schema = protoReadSchemas.get(type);
        if (schema != null) {
            try {
                Method newBuilder = type.getMethod("newBuilder");
                GeneratedMessage.Builder builder = (GeneratedMessage.Builder) newBuilder.invoke(type);
                Schema<GeneratedMessage.Builder> castedSchema = (Schema<GeneratedMessage.Builder>) schema;
                JsonIOUtil.mergeFrom(entityStream, builder, castedSchema, false);
                return builder.build();
            } catch (Exception e) {
                throw new WebApplicationException(e);
            }
        } else {
            return super.readFrom(type, genericType, annotations, mediaType, httpHeaders, entityStream);
        }
    }

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        System.out.println("MATHIAS: "+type);
        return protoWriteSchemas.containsKey(type)
                || super.isWriteable(type, genericType, annotations, mediaType);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void writeTo(Object value, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
                        MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException {
        Schema<?> schema = protoWriteSchemas.get(type);
        if (schema != null) {
            Message message = (Message) value;
            Schema<Message> castedSchema = (Schema<Message>) schema;
            JsonIOUtil.writeTo(entityStream, message, castedSchema, false);
        } else {
            super.writeTo(value, type, genericType, annotations, mediaType, httpHeaders, entityStream);
        }
    }

    boolean isUseNumericFields() {
        return useNumericFields;
    }

    void setUseNumericFields(boolean useNumericFields) {
        this.useNumericFields = useNumericFields;
    }

}