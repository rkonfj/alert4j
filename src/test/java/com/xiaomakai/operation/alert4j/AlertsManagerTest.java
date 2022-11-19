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
public class AlertsManagerTest {

    @Test
    public void testCreate() {
        AlertManagerV2 v2 = new AlertManagerV2("http://10.4.0.55:9093");

        PostableAlert alert = new PostableAlert();
        alert.setAnnotations(new HashMap<>());
        alert.setStartsAt(LocalDateTime.now());
        alert.setEndsAt(LocalDateTime.now().plusMinutes(1));

        Map<String, String> labels = new HashMap<>();
        labels.put("alertname", "任务执行失败");
        alert.setLabels(labels);
        v2.alertsManager().createAlert(Collections.singletonList(alert));
    }

    @Test
    public void testGet() {
        AlertManagerV2 v2 = new AlertManagerV2("http://10.4.0.55:9093");
        List<GettableAlert> alerts = v2.alertsManager().getAlerts(true, null, null, null, null, null);
        System.out.println(alerts);
    }
}
