package com.xiaomakai.operation.alert4j.model;

import lombok.Data;

/**
 * @author rkonfj
 */
@Data
public class Matcher {
    private String name;
    private String value;
    private boolean regex;
    private boolean equal = true;
}
