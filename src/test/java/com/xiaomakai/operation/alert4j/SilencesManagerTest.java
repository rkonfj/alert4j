package com.xiaomakai.operation.alert4j;

import com.xiaomakai.operation.alert4j.model.GettableSilence;
import com.xiaomakai.operation.alert4j.model.Matcher;
import com.xiaomakai.operation.alert4j.model.PostableSilence;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

public class SilencesManagerTest {

    @Test
    public void testCreate() {
        AlertManagerV2 v2 = new AlertManagerV2("http://10.4.0.55:9093");


        PostableSilence silence = new PostableSilence();
        silence.setStartsAt(LocalDateTime.now().plusMinutes(-10));
        silence.setEndsAt(LocalDateTime.now());

        Matcher matcher = new Matcher();
        matcher.setName("alertname");
        matcher.setValue("hello");
        silence.matchers().add(matcher);
        silence.setCreatedBy("rkonfj");
        silence.setComment("not alert in this time range");
        v2.silencesManager().createSilence(silence);
    }

    @Test
    public void testGet() {
        AlertManagerV2 v2 = new AlertManagerV2("http://10.4.0.55:9093");

        List<GettableSilence> silences = v2.silencesManager().getSilences(null);
        System.out.println(silences);
    }

    @Test
    public void testGetByID() {
        AlertManagerV2 v2 = new AlertManagerV2("http://10.4.0.55:9093");

        GettableSilence silence = v2.silencesManager().getSilenceByID("11b3aac8-912a-4ed4-a26e-6b8020d3fa97");
        System.out.println(silence);
    }

    @Test
    public void testDelete() {
        AlertManagerV2 v2 = new AlertManagerV2("http://10.4.0.55:9093");

        v2.silencesManager().deleteSilenceByID("11b3aac8-912a-4ed4-a26e-6b8020d3fa97");
    }
}
