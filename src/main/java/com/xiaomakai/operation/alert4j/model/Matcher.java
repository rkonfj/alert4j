package com.xiaomakai.operation.alert4j.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author rkonfj
 */
@Data
public class Matcher {
    private String name;
    private String value;
    @JsonProperty("isRegex")
    private boolean regex;
    @JsonProperty("isEqual")
    private boolean equal = true;
}
