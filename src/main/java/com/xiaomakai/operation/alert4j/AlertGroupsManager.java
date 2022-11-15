package com.xiaomakai.operation.alert4j;

import com.xiaomakai.operation.alert4j.model.AlertGroup;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

@Headers("Content-Type: application/json;charset=utf-8")
public interface AlertGroupsManager {

    @RequestLine("GET /api/v2/alerts/groups?active={active}&silenced={silenced}&inhibited={inhibited}&filter={filter}&receiver={receiver}")
    List<AlertGroup> getAlertGroups(
            @Param(value = "active") Boolean active,
            @Param(value = "silenced") Boolean silenced,
            @Param(value = "inhibited") Boolean inhibited,
            @Param(value = "filter") List<String> filter,
            @Param(value = "receiver") String receiver);
}
