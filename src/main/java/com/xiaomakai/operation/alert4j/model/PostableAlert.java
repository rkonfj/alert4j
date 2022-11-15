package com.xiaomakai.operation.alert4j.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rkonfj
 */
@Data
public class PostableAlert {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startsAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endsAt;
    private Map<String, String> annotations;
    private Map<String, String> labels;
    private String generatorURL;

    public Labels labels() {
        return new Labels(this);
    }

    public Annotations annotations() {
        return new Annotations(this);
    }

    public static class Labels {
        private final PostableAlert alert;

        public Labels(PostableAlert alert) {
            this.alert = alert;
        }

        public Labels add(String name, String value) {
            if (alert.getLabels() == null) {
                alert.setLabels(new HashMap<>());
            }
            alert.getLabels().put(name, value);
            return this;
        }
    }

    public static class Annotations {
        private final PostableAlert alert;


        public Annotations(PostableAlert alert) {
            this.alert = alert;
        }

        public Annotations add(String name, String value) {
            if (alert.getAnnotations() == null) {
                alert.setAnnotations(new HashMap<>());
            }
            alert.getAnnotations().put(name, value);
            return this;
        }
    }
}
