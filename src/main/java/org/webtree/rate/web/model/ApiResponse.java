package org.webtree.rate.web.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.Date;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
public class ApiResponse<T> {
    private ApiResponseStatus status;
    private Date timestamp = new Date();
    @JsonInclude(Include.NON_NULL)
    private T data;

    public ApiResponse(ApiResponseStatus status, T data) {
        this.status = status;
        this.data = data;
    }

    public ApiResponse(ApiResponseStatus status) {

        this.status = status;
    }

    public ApiResponse() {

    }

    public ApiResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ApiResponseStatus status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
