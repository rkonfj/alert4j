package com.xiaomakai.operation.alert4j.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author jingyk
 * @see PostableAlert
 */
@Data
public class GettableAlert {
    private LocalDateTime startsAt;
    private LocalDateTime endsAt;
    private Map<String, String> annotations;
    private Map<String, String> labels;
    private String generatorURL;
    private List<Receiver> receivers;
    private String fingerprint;
    private LocalDateTime updatedAt;
    private AlertStatus status;
}
