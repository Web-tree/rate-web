package org.webtree.rate.web.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

/**
 * @author Maxim
 */
@Getter
public class ApiResponseStatus {
    private final ApiResponseType type;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String message;

    public ApiResponseStatus(ApiResponseType type) {
        this.type = type;
        message = null;
    }

    public ApiResponseStatus(ApiResponseType type, String message) {
        this.type = type;
        this.message = message;
    }
}
