package org.grozeille.proto;

import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.grozeille.Result;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class SchemaBuilder implements InitializingBean {

    @Autowired
    private ProtobuffJacksonJaxbJsonProvider protobuffJacksonJaxbJsonProvider;


    @Override
    public void afterPropertiesSet() throws Exception {
        Schema<Result> schema = RuntimeSchema.getSchema(Result.class);
        protobuffJacksonJaxbJsonProvider.registerProtoReadSchema(Result.class, schema);
    }
}
