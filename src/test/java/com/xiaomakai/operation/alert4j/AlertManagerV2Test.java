package com.xiaomakai.operation.alert4j;

import com.xiaomakai.operation.alert4j.model.GettableAlert;
import com.xiaomakai.operation.alert4j.model.PostableAlert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jingyk
 */
public class AlertManagerV2Test {

    @Test
    public void testCreate() {
        AlertManagerV2 alertManagerV2 = AlertManagerV2.newInstance("http://192.168.0.6:9093");

        PostableAlert alert = new PostableAlert();
        alert.setAnnotations(new HashMap<>());
        alert.setStartsAt(LocalDateTime.now());
        alert.setEndsAt(LocalDateTime.now().plusMinutes(1));

        Map<String, String> labels = new HashMap<>();
        labels.put("alertname", "任务执行失败");
        alert.setLabels(labels);
        alertManagerV2.createAlert(Collections.singletonList(alert));
    }

    @Test
    public void testGet() {
        AlertManagerV2 alertManagerV2 = AlertManagerV2.newInstance("http://192.168.0.6:9093");
        List<GettableAlert> alerts = alertManagerV2.getAlerts(true, null, null, null, null, null);
        System.out.println(alerts);
    }
}
