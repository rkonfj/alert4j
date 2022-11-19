package com.xiaomakai.operation.alert4j.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/**
 * @author rkonfj
 */
@Data
public class PostableSilence {
    private String id;
    private List<Matcher> matchers;
    /**
     * required
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startsAt;
    /**
     * required
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endsAt;
    /**
     * required
     */
    private String createdBy;
    /**
     * required
     */
    private String comment;


    public Matchers matchers() {
        return new Matchers(this);
    }

    public static class Matchers {
        private final PostableSilence silence;

        public Matchers(PostableSilence silence) {
            this.silence = silence;
        }

        public Matchers add(Matcher matcher) {
            if (silence.getMatchers() == null) {
                silence.setMatchers(new LinkedList<>());
            }
            silence.getMatchers().add(matcher);
            return this;
        }
    }
}
