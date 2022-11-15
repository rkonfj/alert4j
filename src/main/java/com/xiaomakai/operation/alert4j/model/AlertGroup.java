package com.xiaomakai.operation.alert4j.model;

import lombok.Data;

import java.util.List;

/**
 * @author rkonfj
 */
@Data
public class AlertGroup {
    private List<String> labels;
    private Receiver receiver;
    private List<GettableAlert> alerts;
}
