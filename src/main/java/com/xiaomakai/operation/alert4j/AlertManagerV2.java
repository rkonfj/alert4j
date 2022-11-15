package com.xiaomakai.operation.alert4j;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.xiaomakai.operation.alert4j.error.ServerErrorDecoder;
import com.xiaomakai.operation.alert4j.model.GettableAlert;
import com.xiaomakai.operation.alert4j.model.PostableAlert;
import feign.Feign;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

import java.util.Collections;
import java.util.List;

/**
 * @author rkonfj
 */
public interface AlertManagerV2 {

    /**
     * New AlertManagerV2 Instance
     *
     * @param alertManager The AlertManager Server Address
     * @return
     */
    static AlertManagerV2 newInstance(String alertManager) {
        return Feign.builder()
                .encoder(new JacksonEncoder(Collections.singletonList(new JavaTimeModule())))
                .decoder(new JacksonDecoder(Collections.singletonList(new JavaTimeModule())))
                .errorDecoder(new ServerErrorDecoder())
                .target(AlertManagerV2.class, alertManager);

    }

    /**
     * Create new Alerts
     *
     * @param alerts
     */
    @RequestLine("POST /api/v2/alerts")
    @Headers("Content-Type: application/json;charset=utf-8")
    void createAlert(List<PostableAlert> alerts);

    /**
     * Get a list of alerts
     *
     * @param active      Show active alerts
     * @param silenced    Show silenced alerts
     * @param inhibited   Show inhibited alerts
     * @param unprocessed Show unprocessed alerts
     * @param filter      A list of matchers to filter alerts by
     * @param receiver    A regex matching receivers to filter alerts by
     * @return
     */
    @RequestLine("GET /api/v2/alerts?active={active}&silenced={silenced}&inhibited={inhibited}&unprocessed={unprocessed}&filter={filter}&receiver={receiver}")
    @Headers("Content-Type: application/json;charset=utf-8")
    List<GettableAlert> getAlerts(
            @Param(value = "active") Boolean active,
            @Param(value = "silenced") Boolean silenced,
            @Param(value = "inhibited") Boolean inhibited,
            @Param(value = "unprocessed") Boolean unprocessed,
            @Param(value = "filter") List<String> filter,
            @Param(value = "receiver") String receiver);
}
