package com.xiaomakai.operation.alert4j;

import com.xiaomakai.operation.alert4j.model.GettableSilence;
import com.xiaomakai.operation.alert4j.model.PostableSilence;
import com.xiaomakai.operation.alert4j.model.SilenceID;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.lang.NonNull;

import java.util.List;

/**
 * Everything related to Alertmanager silences
 *
 * @author rkonfj
 */
@Headers("Content-Type: application/json;charset=utf-8")
public interface SilencesManager {

    /**
     * Get a list of silences
     *
     * @param filter A list of matchers to filter silences by
     * @return Get silences response
     */
    @RequestLine("GET /api/v2/silences?filter={;filter}")
    List<GettableSilence> getSilences(@Param("filter") List<String> filter);

    /**
     * Post a new silence or update an existing one
     *
     * @param silence The silence to create
     * @return Create / update silence response
     */
    @RequestLine("POST /api/v2/Silences")
    SilenceID createSilence(PostableSilence silence);

    /**
     * Get a silence by its ID
     *
     * @param silenceID ID of the silence to get
     * @return Get silence response
     */
    @RequestLine("GET /api/v2/silence/{silenceID}")
    GettableSilence getSilenceByID(@Param("silenceID") @NonNull String silenceID);

    /**
     * Delete a silence by its ID
     *
     * @param silenceID ID of the silence to delete
     */
    @RequestLine("DELETE /api/v2/silence/{silenceID}")
    void deleteSilenceByID(@Param("silenceID") @NonNull String silenceID);

}
