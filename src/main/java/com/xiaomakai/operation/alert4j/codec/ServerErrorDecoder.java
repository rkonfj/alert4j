package com.xiaomakai.operation.alert4j.codec;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.util.StreamUtils;

import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

/**
 * @author rkonfj
 */
public class ServerErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        try {
            String responseBody = StreamUtils.copyToString(response.body().asInputStream(), StandardCharsets.UTF_8);
            if (response.status() >= HttpURLConnection.HTTP_BAD_REQUEST
                    && response.status() < HttpURLConnection.HTTP_INTERNAL_ERROR) {
                return new IllegalArgumentException(responseBody);
            }
            return new IllegalStateException(responseBody);
        } catch (Exception e) {
            return new Exception(String.format("%s.[%s]", response.reason(), e.getMessage()));
        }
    }
}
