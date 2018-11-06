package com.qq.weixin.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * A {@linkplain retrofit2.Converter.Factory converter} which uses Jackson.
 * <p>
 * Because Jackson is so flexible in the types it supports, this converter assumes that it can
 * handle all types. If you are mixing JSON serialization with something else (such as protocol
 * buffers), you must {@linkplain Retrofit.Builder#addConverterFactory(retrofit2.Converter.Factory) add this
 * instance} last to allow the other converters a chance to see their types.
 */
public final class ConverterFactory extends retrofit2.Converter.Factory {

    private final ObjectMapper objectMapper;

    private final DefaultConverter<?, ?> defaultJacksonConverter = new DefaultConverter();

    public ConverterFactory(ObjectMapper objectMapper) {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        this.objectMapper = objectMapper;
    }

    @Override
    public retrofit2.Converter responseBodyConverter(Type type, Annotation[] annotations,
                                                     Retrofit retrofit) {
        return new JacksonResponseBodyConverter(type, annotations);
    }

    @Override
    public retrofit2.Converter requestBodyConverter(Type type,
                                                    Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return new JacksonRequestBodyConverter(type, methodAnnotations);
    }

    private DefaultConverter createConverter(Annotation[] annotations) {
        for (Annotation annotation : annotations) {
            if (annotation instanceof Converter) {
                try {
                    return ((Converter) annotation).value().newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return defaultJacksonConverter;
    }

    private class JacksonRequestBodyConverter<T> implements retrofit2.Converter<T, RequestBody> {
        protected final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");

        protected final Type type;
        private final Annotation[] methodAnnotations;

        private JacksonRequestBodyConverter(Type type, Annotation[] methodAnnotations) {
            this.type = type;
            this.methodAnnotations = methodAnnotations;
        }

        @Override
        public final RequestBody convert(T value) throws IOException {
            DefaultConverter converter = createConverter(methodAnnotations);
            byte[] bytes = converter.request(objectMapper, type, value);
            return RequestBody.create(MEDIA_TYPE, bytes);
        }

    }

    private class JacksonResponseBodyConverter<T> implements retrofit2.Converter<ResponseBody, T> {
        private final Type type;
        private final Annotation[] annotations;

        private JacksonResponseBodyConverter(Type type, Annotation[] annotations) {
            this.type = type;
            this.annotations = annotations;
        }

        @Override
        public final T convert(ResponseBody value) throws IOException {
            byte[] bytes = value.bytes();
            DefaultConverter converter = createConverter(annotations);
            return (T) converter.response(objectMapper, type, bytes);
        }

    }

}
