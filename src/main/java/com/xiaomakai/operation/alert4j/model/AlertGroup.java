package com.xiaomakai.operation.alert4j.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author rkonfj
 */
@Data
public class AlertGroup {
    private Map<String, String> labels;
    private Receiver receiver;
    private List<GettableAlert> alerts;
}
