package com.xiaomakai.operation.alert4j.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
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
}
