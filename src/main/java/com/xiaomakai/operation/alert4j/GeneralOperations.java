package com.xiaomakai.operation.alert4j;

import com.xiaomakai.operation.alert4j.model.Receiver;
import feign.Headers;
import feign.RequestLine;

import java.util.List;

/**
 * General Alertmanager operations
 *
 * @author rkonfj
 */
@Headers("Content-Type: application/json;charset=utf-8")
public interface GeneralOperations {

    @RequestLine("GET /api/v2/receivers")
    List<Receiver> getReceivers();
}
