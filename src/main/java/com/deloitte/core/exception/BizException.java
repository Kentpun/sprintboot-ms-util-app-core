package com.deloitte.core.exception;

import com.deloitte.core.response.Response;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class BizException extends RuntimeException {
    private Response response;
    private Object map;

    public BizException(Response response, Map map) {
        this.response = response;
        this.map = map;
    }

    public BizException(Response response) {
        super(response.getMessage());
        this.response = response;
    }
}
