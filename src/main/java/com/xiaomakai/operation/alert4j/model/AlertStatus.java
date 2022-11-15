package com.xiaomakai.operation.alert4j.model;

import lombok.Data;

import java.util.List;

/**
 * @author jingyk
 */
@Data
public class AlertStatus {
    private String state;
    private List<String> silencedBy;
    private List<String> inhibitedBy;
}
