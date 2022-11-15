package com.xiaomakai.operation.alert4j.error;

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
            if (response.status() >= HttpURLConnection.HTTP_BAD_REQUEST && response.status() < HttpURLConnection.HTTP_INTERNAL_ERROR) {
                return new IllegalArgumentException(StreamUtils.copyToString(response.body().asInputStream(), StandardCharsets.UTF_8));
            }
            return new Exception(StreamUtils.copyToString(response.body().asInputStream(), StandardCharsets.UTF_8));
        } catch (Exception e) {
            return new Exception(response.reason());
        }
    }
}
