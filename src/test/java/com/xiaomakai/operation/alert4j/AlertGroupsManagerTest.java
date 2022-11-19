package com.xiaomakai.operation.alert4j;

import com.xiaomakai.operation.alert4j.model.AlertGroup;
import org.junit.Test;

import java.util.List;

public class AlertGroupsManagerTest {


    @Test
    public void testGet() {
        AlertManagerV2 v2 = new AlertManagerV2("http://10.4.0.55:9093");
        List<AlertGroup> alertGroups = v2.alertGroupsManager().getAlertGroups(null, null, null, null, null);
        alertGroups.forEach(System.out::println);
    }
}
