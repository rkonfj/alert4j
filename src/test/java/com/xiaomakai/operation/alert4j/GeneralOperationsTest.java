package com.xiaomakai.operation.alert4j;

import com.xiaomakai.operation.alert4j.model.Receiver;
import org.junit.Test;

import java.util.List;

public class GeneralOperationsTest {

    @Test
    public void testGet() {
        AlertManagerV2 v2 = new AlertManagerV2("http://10.4.0.55:9093");

        List<Receiver> receivers = v2.generalOperations().getReceivers();
        System.out.println(receivers);
    }
}
