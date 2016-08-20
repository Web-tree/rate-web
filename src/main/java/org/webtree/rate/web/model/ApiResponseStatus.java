package org.webtree.rate.web.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.springframework.http.HttpStatus;

import java.net.HttpURLConnection;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
public class ApiResponseStatus {
    private int code;
    @JsonInclude(Include.NON_EMPTY)
    private String message;

    public static ApiResponseStatus getOkStatus() {
        return new ApiResponseStatus(HttpStatus.OK);
    }

    public static ApiResponseStatus getErrorStatus() {
        return new ApiResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static ApiResponseStatus getStatus(HttpStatus code) {
        return new ApiResponseStatus(code);
    }

    public ApiResponseStatus(HttpStatus code, String message) {
        this.code = code.value();
        this.message = message;
    }

    public ApiResponseStatus(HttpStatus code) {
        this.code = code.value();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
