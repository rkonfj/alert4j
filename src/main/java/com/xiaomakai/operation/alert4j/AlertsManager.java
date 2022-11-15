package com.xiaomakai.operation.alert4j;

import com.xiaomakai.operation.alert4j.model.GettableAlert;
import com.xiaomakai.operation.alert4j.model.PostableAlert;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

/**
 * @author rkonfj
 */
@Headers("Content-Type: application/json;charset=utf-8")
public interface AlertsManager {

    /**
     * Create new Alerts
     *
     * @param alerts The alerts to create
     */
    @RequestLine("POST /api/v2/alerts")
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
