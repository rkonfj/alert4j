package com.xiaomakai.operation.alert4j.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author rkonfj
 */
@Data
public class GettableSilence {
    private String id;
    private SilenceStatus status;
    private LocalDateTime updatedAt;
    private List<Matcher> matchers;
    private LocalDateTime startsAt;
    private LocalDateTime endsAt;
    private String createdBy;
    private String comment;
}
