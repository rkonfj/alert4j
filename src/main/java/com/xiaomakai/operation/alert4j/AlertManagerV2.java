package com.xiaomakai.operation.alert4j;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.xiaomakai.operation.alert4j.codec.ServerErrorDecoder;
import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;

import java.util.Collections;

public class AlertManagerV2 {
    private final GeneralOperations generalOperations;
    private final SilencesManager silencesManager;
    private final AlertsManager alertsManager;
    private final AlertGroupsManager alertGroupsManager;

    public AlertManagerV2(String alertManager) {
        Encoder encoder = new JacksonEncoder(Collections.singletonList(new JavaTimeModule()));
        Decoder decoder = new JacksonDecoder(Collections.singletonList(new JavaTimeModule()));
        OkHttpClient httpClient = new OkHttpClient();
        ServerErrorDecoder errorDecoder = new ServerErrorDecoder();
        this.generalOperations = Feign.builder()
                .encoder(encoder)
                .decoder(decoder)
                .errorDecoder(errorDecoder)
                .client(httpClient)
                .target(GeneralOperations.class, alertManager);
        this.silencesManager = Feign.builder()
                .encoder(encoder)
                .decoder(decoder)
                .errorDecoder(errorDecoder)
                .client(httpClient)
                .target(SilencesManager.class, alertManager);
        this.alertsManager = Feign.builder()
                .encoder(encoder)
                .decoder(decoder)
                .errorDecoder(errorDecoder)
                .client(httpClient)
                .target(AlertsManager.class, alertManager);
        this.alertGroupsManager = Feign.builder()
                .encoder(encoder)
                .decoder(decoder)
                .errorDecoder(errorDecoder)
                .client(httpClient)
                .target(AlertGroupsManager.class, alertManager);
    }

    public GeneralOperations generalOperations() {
        return generalOperations;
    }

    public SilencesManager silencesManager() {
        return silencesManager;
    }

    public AlertsManager alertsManager() {
        return alertsManager;
    }

    public AlertGroupsManager alertGroupsManager() {
        return alertGroupsManager;
    }
}
