package org.webtree.rate.web.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;

import java.util.Date;

/**
 * @author Maxim
 */
@Getter
public class ApiResponse<T> {
    private final ApiResponseStatus status;
    private final Date timestamp = new Date();
    @JsonInclude(Include.NON_NULL)
    private final T data;

    public ApiResponse(ApiResponseStatus status, T data) {
        this.status = status;
        this.data = data;
    }

    public ApiResponse(ApiResponseStatus status) {
        this.status = status;
        this.data = null;
    }
}
